import java.util.ArrayList;
import java.util.List;

public class PatternFileParser {
    private final String patternFileContents;

    public PatternFileParser(String patternFileContents) {
        this.patternFileContents = patternFileContents;
    }

    private List<String[]> getParsedString() {
        String[] lines = patternFileContents.split("\\n");
        List<String[]> linesSplit = new ArrayList<>();
        for (var line : lines) {
            line = line.replace("\"", "");
            linesSplit.add(line.split(";"));
        }
        return linesSplit;
    }

    public List<Pattern> getPatterns() {
        List<String[]> parsedString = getParsedString();
        List<Pattern> patterns = new ArrayList<>();
        for (var array : parsedString) {
            int priority = Integer.parseInt(array[0]);
            String patternString = array[1];
            String fileType = array[2];
            Pattern pattern = new Pattern(priority, patternString, fileType);
            patterns.add(pattern);
        }
        return patterns;
    }




}
