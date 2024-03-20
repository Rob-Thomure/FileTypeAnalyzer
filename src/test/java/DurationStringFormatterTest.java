import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DurationStringFormatterTest {

    @Test
    public void testFormatter100millis() {
        int seconds = 5;
        int milliseconds = 100;
        DurationStringFormatter durationStringFormatter = new DurationStringFormatter(seconds, milliseconds);
        String expected = "5.100 seconds";
        Assertions.assertEquals(expected, durationStringFormatter.toString());
    }

    @Test
    public void testFormatter1millis() {
        int seconds = 5;
        int milliseconds = 1;
        DurationStringFormatter durationStringFormatter = new DurationStringFormatter(seconds, milliseconds);
        String expected = "5.001 seconds";
        Assertions.assertEquals(expected, durationStringFormatter.toString());
    }


}
