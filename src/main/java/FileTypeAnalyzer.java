import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileTypeAnalyzer {
    private SearchInterface searchInterface;
    private final List<Pattern> patterns;

    public FileTypeAnalyzer(SearchInterface searchInterface, List<Pattern> patterns) {
        this.searchInterface = searchInterface;
        this.patterns = patterns;
    }

    public String getFileType(String fileContents) {
        List<Pattern> patternsFound = new ArrayList<>();
        // make list of patterns found
        patterns.forEach(pattern -> {
            searchInterface = new KmpSearch();
            boolean found = searchInterface.search(fileContents, pattern.getPattern());
            if (found) {
                patternsFound.add(pattern);
            }
        });

        return determineFileType(patternsFound);
    }

    private String determineFileType(List<Pattern> patternsFound) {
        if (patternsFound.isEmpty())
            return "Unknown file type";
        else
            return patternsFound.get(patternsFound.size() - 1).getFileType();

//        else if (patternsFound.size() == 1)
//            return patternsFound.get(0).getFileType();
//        else {
//            patterns.sort(Comparator.comparing(Pattern::getPriority));
//            Collections.reverse(patterns);
//            return patterns.get(0).getFileType();
//        }
    }
}
