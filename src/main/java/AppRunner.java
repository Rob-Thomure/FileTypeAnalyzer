import java.io.File;
import java.util.Map;

public class AppRunner {
    private final CommandLineArgsWithDirectory commandLineArgsWithDirectory;

    public AppRunner(String[] args) {
        commandLineArgsWithDirectory = new CommandLineArgsWithDirectory(args);
    }


    public void run() {
        MultiFileTypeAnalyzer multiFileTypeAnalyzer = new MultiFileTypeAnalyzer(commandLineArgsWithDirectory);
        Map<File, String> filesMap = multiFileTypeAnalyzer.getFilesMap();
        filesMap.forEach((key, value) -> System.out.println(key.getName() + ": " + value));
    }

}
