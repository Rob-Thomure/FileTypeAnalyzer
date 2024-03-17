import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NaiveSearchTest {

    String PdfFleContents = new FileContents("test.pdf").getFileContents();
    String JpgFileContents = new FileContents("lambdas.jpg").getFileContents();

    @Test
    public void testSearchMatches() {
        SearchInterface searchInterface = new NaiveSearch();
        boolean matches = searchInterface.search(PdfFleContents, "%PDF-");
        assertTrue(matches);
    }

    @Test
    public void testSearchDoesNotMatch() {
        SearchInterface searchInterface = new NaiveSearch();
        boolean matches = searchInterface.search(JpgFileContents, "%PDF-");
        assertFalse(matches);
    }
}
