import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class MultiFileTypeAnalyzer {
    private final String directoryName;
    private final Map<File, String> filesMap;
    private final List<Pattern> patterns;

    public MultiFileTypeAnalyzer(CommandLineArgs commandLineArgs,
                                 List<Pattern> patterns) {
        this.directoryName = commandLineArgs.getDirectoryName();
        this.filesMap = new HashMap<>();
        this.patterns = patterns;
        File[] filesList = createFileList();
        checkFileTypes(filesList);
    }

    private File[] createFileList() {
        File directory = new File(directoryName);
        return directory.listFiles();
    }

    private void checkFileTypes(File[] files) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<String>> futures = new ArrayList<>();
        for (File file : files) {
            FileTypeAnalyzer fileTypeAnalyzer = new FileTypeAnalyzer(new KmpSearch(), patterns);
            String fileContents = new FileContents(file.toString()).getFileContents();
            Future<String> future = executorService.submit(() -> fileTypeAnalyzer.getFileType(fileContents));
            futures.add(future);
        }

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            try {
                String fileType = futures.get(i).get();
                filesMap.put(file, fileType);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        executorService.shutdown();
        try {
            //noinspection ResultOfMethodCallIgnored
            executorService.awaitTermination(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println("Failed to shutdown ExecutorService");
        }
    }


    public Map<File, String> getFilesMap() {
        return filesMap;
    }
}
