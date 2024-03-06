
public class Main {

    public static void main(String[] args) {
        String filePath = args[0];
        String stringPattern = args[1];
        String resultingFileType = args[2];

        FileTypeAnalyzer fileTypeAnalyzer = new FileTypeAnalyzer(filePath, stringPattern, resultingFileType);
        System.out.println(fileTypeAnalyzer.getFileType());
    }
}
