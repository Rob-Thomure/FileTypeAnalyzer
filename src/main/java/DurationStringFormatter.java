public class DurationStringFormatter {
    private final int seconds;
    private final int milliseconds;

    public DurationStringFormatter(int seconds, int milliseconds) {
        this.seconds = seconds;
        this.milliseconds = milliseconds;
    }

    public String toString() {
        return String.format("%d.%03d seconds", seconds, milliseconds);
    }
}
