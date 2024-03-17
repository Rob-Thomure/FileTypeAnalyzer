import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasicSearchTest {
    String PdfFleContents = new FileContents("test.pdf").getFileContents();
    String JpgFileContents = new FileContents("lambdas.jpg").getFileContents();

    @Test
    public void testSearchMatches() {
        SearchInterface searchInterface = new BasicSearch();
        boolean matches = searchInterface.search(PdfFleContents, "%PDF-");
        assertTrue(matches);
    }

    @Test
    public void testSearchDoesNotMatch() {
        SearchInterface searchInterface = new BasicSearch();
        boolean matches = searchInterface.search(JpgFileContents, "%PDF-");
        assertFalse(matches);
    }


}
