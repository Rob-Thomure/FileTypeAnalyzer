public class DurationStringFormatter {
    private int seconds;
    private int milliseconds;

    public DurationStringFormatter(int seconds, int milliseconds) {
        this.seconds = seconds;
        this.milliseconds = milliseconds;
    }

    public String toString() {
        return String.format("%d.%03d seconds", seconds, milliseconds);
    }
}
