import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandLineArgsTest {

    @Test
    public void test3Args() {
        String[] args = {"test.pdf", "%PDF-", "PDF document"};
        CommandLineArgs commandLineArgs = new CommandLineArgs(args);
        String[] results = {commandLineArgs.getFilePath(),
                commandLineArgs.getSearchString(),
                commandLineArgs.getExpectedFileType()};
        assertArrayEquals(args, results);
    }

    @Test
    public void test4Args() {
        String[] args = {"--naive" ,"test.pdf", "%PDF-", "PDF document"};
        CommandLineArgs commandLineArgs = new CommandLineArgs(args);
        String[] results = {commandLineArgs.getSearchType(),
                commandLineArgs.getFilePath(),
                commandLineArgs.getSearchString(),
                commandLineArgs.getExpectedFileType()};
        assertArrayEquals(args, results);
    }
}
