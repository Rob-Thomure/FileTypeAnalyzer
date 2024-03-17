import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileContents {
    String filePath;

    public FileContents(String filePath) {
        this.filePath = filePath;
    }

    public String getFileContents() {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            return new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


}