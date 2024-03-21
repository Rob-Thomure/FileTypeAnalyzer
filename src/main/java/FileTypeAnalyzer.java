
public class FileTypeAnalyzer {
    final private SearchInterface searchInterface;
    final private String fileContents;
    final private String searchString;
    final private String resultType;

    public FileTypeAnalyzer(SearchInterface searchInterface, String fileContents, String searchString,
                            String resultType) {
        this.searchInterface = searchInterface;
        this.fileContents = fileContents;
        this.searchString = searchString;
        this.resultType = resultType;
    }

    public String run() {
        boolean found = searchInterface.search(fileContents, searchString);
        return found ? resultType : "Unknown file type";
    }
}
