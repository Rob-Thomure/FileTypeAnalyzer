import java.time.Duration;
import java.time.Instant;

public class Stopwatch {
    private Instant start;
    private Instant stop;

    public Stopwatch() {
        this.start = Instant.now();
        this.stop = Instant.now();
    }

    public void start() {
        this.start = Instant.now();
    }

    public void stop() {
        this.stop = Instant.now();
    }

    public int getSeconds() {
        return Duration.between(start, stop).toSecondsPart();
    }

    public int getMilliseconds() {
        return Duration.between(start, stop).toMillisPart();
    }
}
