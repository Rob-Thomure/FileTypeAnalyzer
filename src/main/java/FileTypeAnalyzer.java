import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTypeAnalyzer {
    private String relativePath;
    private String patternString;
    private String resultString;
    private final String UNKNOWN_FILE_TYPE = "Unknown file type";

    public FileTypeAnalyzer(String filePath, String patternString, String resultString) {
        this.relativePath = filePath;
        this.patternString = patternString;
        this.resultString = resultString;
    }

    public String getFileType() {
        String fileLines = readAllLines();
        boolean matches = fileLines.contains(patternString);
        return matches ? resultString : UNKNOWN_FILE_TYPE;
    }

    private String readAllLines() {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(relativePath));
            return new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


}
