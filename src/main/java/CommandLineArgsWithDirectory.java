public class CommandLineArgsWithDirectory {
    private final String directoryName;
    private final String pattern;
    private final String fileType;

    public CommandLineArgsWithDirectory(String[] args) {
        this.directoryName = args[0];
        this.pattern = args[1];
        this.fileType = args[2];
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public String getPattern() {
        return pattern;
    }

    public String getFileType() {
        return fileType;
    }
}
