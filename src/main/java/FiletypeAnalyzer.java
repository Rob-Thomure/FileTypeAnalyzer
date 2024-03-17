
public class FiletypeAnalyzer {
    private final String relativePath;
    private final String patternString;
    private final String resultString;
    private final SearchInterface searchInterface;

    public FiletypeAnalyzer(String filePath, String patternString, String resultString, SearchInterface searchInterface) {
        this.relativePath = filePath;
        this.patternString = patternString;
        this.resultString = resultString;
        this.searchInterface = searchInterface;
    }

    public String getFileType() {
        String fileContents = new FileContents(relativePath).getFileContents();
        boolean matches = searchInterface.search(fileContents, patternString);
        String UNKNOWN_FILE_TYPE = "Unknown file type";
        return matches ? resultString : UNKNOWN_FILE_TYPE;
    }
}
