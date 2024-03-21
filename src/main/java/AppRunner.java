public class AppRunner {
    private final CommandLineArgs commandLineArgs;

    public AppRunner(String[] args) {
        commandLineArgs = new CommandLineArgs(args);
    }

    public void run() {
        SearchInterface searchInterface = makeSearchType(commandLineArgs.getSearchType());
        String fileContents = new FileContents(commandLineArgs.getFilePath()).getFileContents();
        String searchString = commandLineArgs.getSearchString();
        String expectedFileType = commandLineArgs.getExpectedFileType();
        FileTypeAnalyzer filetypeAnalyzer = new FileTypeAnalyzer(searchInterface, fileContents, searchString,
                expectedFileType);
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        String fileType = filetypeAnalyzer.run();
        stopwatch.stop();
        String duration = new DurationStringFormatter(stopwatch.getSeconds(), stopwatch.getMilliseconds()).toString();
        System.out.println(fileType);
        System.out.println(duration);
    }

    private SearchInterface makeSearchType(String searchTypeString) {
        return switch (searchTypeString) {
            case "--naive" -> new NaiveSearch();
            case "--KMP" -> new KmpSearch();
            default -> new BasicSearch();
        };
    }
}
