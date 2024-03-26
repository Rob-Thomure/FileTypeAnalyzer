import java.io.File;
import java.util.List;
import java.util.Map;

public class AppRunner {
    private final CommandLineArgs commandLineArgs;

    public AppRunner(String[] args) {
        commandLineArgs = new CommandLineArgs(args);
    }


    public void run() {
        List<Pattern> patterns = getPatterns();
        MultiFileTypeAnalyzer multiFileTypeAnalyzer = new MultiFileTypeAnalyzer(commandLineArgs, patterns);
        Map<File, String> filesMap = multiFileTypeAnalyzer.getFilesMap();
        filesMap.forEach((key, value) -> System.out.println(key.getName() + ": " + value));
    }

    private List<Pattern> getPatterns() {
        String fileContents = new FileContents(commandLineArgs.getPatternsDB()).getFileContents();
        PatternFileParser patternFileParser = new PatternFileParser(fileContents);
        return patternFileParser.getPatterns();
    }

}
