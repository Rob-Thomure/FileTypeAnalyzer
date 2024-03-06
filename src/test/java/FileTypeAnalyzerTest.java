import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class FileTypeAnalyzerTest {

    @Test
    public void testClassInstantiation() {
        FileTypeAnalyzer fileTypeAnalyzer = new FileTypeAnalyzer("test.pdf", "%PDF-", "PDF document");
    }

    @Test
    public void testPdf() {
        FileTypeAnalyzer fileTypeAnalyzer = new FileTypeAnalyzer("test.pdf", "%PDF-", "PDF document");
        String result = fileTypeAnalyzer.getFileType();
        assertEquals("PDF document", result);
    }

    @Test
    public void testUnknownType() {
        FileTypeAnalyzer fileTypeAnalyzer = new FileTypeAnalyzer("lambdas.jpg", "%PDF-", "PDF document");
        String result = fileTypeAnalyzer.getFileType();
        assertEquals("Unknown file type", result);
    }
}
