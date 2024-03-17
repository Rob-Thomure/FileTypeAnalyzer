import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandLineArgsTest {

    @Test
    public void test3Args() {
        String[] args = {"test.pdf", "%PDF-", "PDF document"};
        CommandLineArgs commandLineArgs = new CommandLineArgs(args);
        String[] results = {commandLineArgs.getFilePath(),
                commandLineArgs.getStringPattern(),
                commandLineArgs.getResultingFileType()};
        Assertions.assertArrayEquals(args, results);
    }

    @Test
    public void test4Args() {
        String[] args = {"--naive" ,"test.pdf", "%PDF-", "PDF document"};
        CommandLineArgs commandLineArgs = new CommandLineArgs(args);
        String[] results = {commandLineArgs.getSearchType(),
                commandLineArgs.getFilePath(),
                commandLineArgs.getStringPattern(),
                commandLineArgs.getResultingFileType()};
        Assertions.assertArrayEquals(args, results);
    }
}
