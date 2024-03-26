public class CommandLineArgs {
    private final String directoryName;
    private final String patternsDB;

    public CommandLineArgs(String[] args) {
        this.directoryName = args[0];
        this.patternsDB = args[1];
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public String getPatternsDB() {
        return patternsDB;
    }
}
