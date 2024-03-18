import java.time.Duration;
import java.time.Instant;

public class Stopwatch {
    private Instant start;
    private Instant stop;

    public void start() {
        this.start = Instant.now();
    }

    public void stop() {
        this.stop = Instant.now();
    }

    public long getSeconds() {
        long seconds = Duration.between(start, stop).getSeconds();
        return seconds;
    }

    public void getMilliseconds() {


        Duration duration = Duration.between(start, stop);
        int seconds = duration.toSecondsPart();
        int milliseconds = duration.toMillisPart();

        System.out.println(seconds);
        System.out.println(milliseconds);
        System.out.println(duration);

        String string = String.format("%d.%03d", seconds, milliseconds);
        System.out.println(string);
    }

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stopwatch.stop();
        stopwatch.getMilliseconds();


    }


}
