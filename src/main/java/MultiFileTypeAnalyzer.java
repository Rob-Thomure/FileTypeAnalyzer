import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiFileTypeAnalyzer {
    private final String directoryName;
    private final Map<File, String> filesMap;
    private final String pattern;
    private final String fileType;

    public MultiFileTypeAnalyzer(CommandLineArgsWithDirectory commandLineArgsWithDirectory) {
        this.directoryName = commandLineArgsWithDirectory.getDirectoryName();
        this.pattern = commandLineArgsWithDirectory.getPattern();
        this.fileType = commandLineArgsWithDirectory.getFileType();
        this.filesMap = new HashMap<>();
        checkFileTypes(createFileList());
    }

    private File[] createFileList() {
        File directory =  new File(directoryName);
        return directory.listFiles();
    }

    private void checkFileTypes(File[] files) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (File file : files) {
            String fileContents = new FileContents(file.toString()).getFileContents();
            SearchInterface searchInterface = new KmpSearch();
            FileTypeAnalyzer fileTypeAnalyzer = new FileTypeAnalyzer(searchInterface, fileContents, pattern, fileType);
            executorService.submit(() -> {
                String fileTypeResult = fileTypeAnalyzer.run();
                filesMap.put(file, fileTypeResult);
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<File, String> getFilesMap() {
        return filesMap;
    }
}
