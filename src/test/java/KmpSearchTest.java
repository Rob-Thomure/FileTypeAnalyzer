import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KmpSearchTest {

    String PdfFleContents = new FileContents("test.pdf").getFileContents();
    String JpgFileContents = new FileContents("lambdas.jpg").getFileContents();

    @Test
    public void testSearchMatches() {
        SearchInterface searchInterface = new KmpSearch();
        boolean matches = searchInterface.search("BACBACBAD", "BACBAD");
        assertTrue(matches);
    }

    @Test
    public void testZipArchive() {
        SearchInterface searchInterface = new KmpSearch();
        String fileContents = new FileContents("test_files/doc1.txt").getFileContents();
        boolean matches = searchInterface.search("PKC", "PK");
        assertTrue(matches);
    }

    @Test
    public void testShorterContentsThanPatternString() {
        SearchInterface searchInterface = new KmpSearch();
        String fileContents = "PKC";
        String patternString = "pmview";
        boolean matches = searchInterface.search(fileContents, patternString);
        assertFalse(matches);
    }

}
