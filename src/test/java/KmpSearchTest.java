import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KmpSearchTest {

    String PdfFleContents = new FileContents("test.pdf").getFileContents();
    String JpgFileContents = new FileContents("lambdas.jpg").getFileContents();

    @Test
    public void testSearchMatches() {
        SearchInterface searchInterface = new KmpSearch();
        boolean matches = searchInterface.search("BACBACBAD", "BACBAD");
        assertTrue(matches);
    }
}
