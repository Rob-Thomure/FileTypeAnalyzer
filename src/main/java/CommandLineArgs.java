public class CommandLineArgs {
    private String filePath;
    private String stringPattern;
    private String resultingFileType;
    private String searchType;

    public CommandLineArgs(String[] args) {
        assignFields(args);
    }

    private void assignFields(String[] args) {
        switch (args.length) {
            case 3 -> threeArgs(args);
            case 4 -> fourArgs(args);
        }
    }

    private void threeArgs(String[] args) {
        this.filePath = args[0];
        this.stringPattern = args[1];
        this.resultingFileType = args[2];
        this.searchType = "--basic";
    }

    private void fourArgs(String[] args) {
        this.searchType = args[0];
        this.filePath = args[1];
        this.stringPattern = args[2];
        this.resultingFileType = args[3];
    }

    public String getFilePath() {
        return filePath;
    }

    public String getStringPattern() {
        return stringPattern;
    }

    public String getResultingFileType() {
        return resultingFileType;
    }

    public String getSearchType() {
        return searchType;
    }
}
