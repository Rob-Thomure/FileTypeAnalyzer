import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class FileTypeAnalyzerTest {

    @Test
    public void testClassInstantiation() {
        SearchInterface searchInterface = new BasicSearch();
        FiletypeAnalyzer fileTypeAnalyzer = new FiletypeAnalyzer("test.pdf", "%PDF-",
                "PDF document", searchInterface);
    }

    @Test
    public void testBasicSearchPdf() {
        SearchInterface searchInterface = new BasicSearch();
        FiletypeAnalyzer fileTypeAnalyzer = new FiletypeAnalyzer("test.pdf", "%PDF-",
                "PDF document", searchInterface);
        String result = fileTypeAnalyzer.getFileType();
        assertEquals("PDF document", result);
    }

    @Test
    public void testBasicSearchUnknownType() {
        SearchInterface searchInterface = new BasicSearch();
        FiletypeAnalyzer fileTypeAnalyzer = new FiletypeAnalyzer("lambdas.jpg", "%PDF-",
                "PDF document", searchInterface);
        String result = fileTypeAnalyzer.getFileType();
        assertEquals("Unknown file type", result);
    }

    @Test
    public void testNaiveSearchPdf() {
        SearchInterface searchInterface = new NaiveSearch();
        FiletypeAnalyzer fileTypeAnalyzer = new FiletypeAnalyzer("test.pdf", "%PDF-",
                "PDF document", searchInterface);
        String result = fileTypeAnalyzer.getFileType();
        assertEquals("PDF document", result);
    }

    @Test
    public void testNaiveSearchUnknowntype() {
        SearchInterface searchInterface = new NaiveSearch();
        FiletypeAnalyzer fileTypeAnalyzer = new FiletypeAnalyzer("lambdas.jpg", "%PDF-",
                "PDF document", searchInterface);
        String result = fileTypeAnalyzer.getFileType();
        assertEquals("Unknown file type", result);
    }
}
