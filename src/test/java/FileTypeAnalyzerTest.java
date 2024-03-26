import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileTypeAnalyzerTest {

    @Test
    public void testZipArchive() {
        SearchInterface searchInterface = new KmpSearch();
        String fileContents = new FileContents("test_files/doc1.txt").getFileContents();

        String patternContents = new FileContents("patterns.db").getFileContents();
        PatternFileParser patternFileParser = new PatternFileParser(patternContents);
        List<Pattern> patterns = patternFileParser.getPatterns();
        FileTypeAnalyzer fileTypeAnalyzer = new FileTypeAnalyzer(searchInterface, patterns);
        String results = fileTypeAnalyzer.getFileType(fileContents);
        assertEquals("Zip archive", results);
    }

    @Test
    public void testZipArchiveBasicSearch() {
        SearchInterface searchInterface = new BasicSearch();
        String fileContents = new FileContents("test_files/doc1.txt").getFileContents();

        String patternContents = new FileContents("patterns.db").getFileContents();
        PatternFileParser patternFileParser = new PatternFileParser(patternContents);
        List<Pattern> patterns = patternFileParser.getPatterns();
        FileTypeAnalyzer fileTypeAnalyzer = new FileTypeAnalyzer(searchInterface, patterns);
        String results = fileTypeAnalyzer.getFileType(fileContents);
        assertEquals("Zip archive", results);
    }

    @Test
    public void testPDF() {
        SearchInterface searchInterface = new KmpSearch();
        String fileContents = new FileContents("test_files/test2.pdf").getFileContents();

        String patternContents = new FileContents("patterns.db").getFileContents();
        PatternFileParser patternFileParser = new PatternFileParser(patternContents);
        List<Pattern> patterns = patternFileParser.getPatterns();
        FileTypeAnalyzer fileTypeAnalyzer = new FileTypeAnalyzer(searchInterface, patterns);
        String results = fileTypeAnalyzer.getFileType(fileContents);
        assertEquals("PDF document", results);
    }
}
