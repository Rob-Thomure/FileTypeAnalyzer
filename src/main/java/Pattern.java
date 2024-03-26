public class Pattern {
    private final int priority;
    private final String pattern;
    private final String fileType;

    public Pattern(int priority, String pattern, String fileType) {
        this.priority = priority;
        this.pattern = pattern;
        this.fileType = fileType;
    }

    public int getPriority() {
        return priority;
    }

    public String getPattern() {
        return pattern;
    }

    public String getFileType() {
        return fileType;
    }

    @Override
    public String toString() {
        return "Pattern{" +
                "priority=" + priority +
                ", pattern='" + pattern + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
