
public class KmpSearch implements SearchInterface {
    private int textIndex = 0;
    private int patternIndex = 0;
    private int numCharsMatched = 0;
    private int textStartingIndex = 0;
    int[] prefixArray;

    @Override
    public boolean search(String text, String pattern) {
        prefixArray = prefixFunction(pattern);
        while (textIndex < text.length()) {
            if (text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                charMatchedSetIndexes();
            } else {
                if (patternIndex == 0) {
                    firstPatternCharMismatchedSetIndexes();
                } else {
                    nextPatternCharMismatchedSetIndexes();
                }
            }
            if (numCharsMatched == pattern.length()) {
                return true;
            }
        }
        return false;
    }

    private void charMatchedSetIndexes() {
        textIndex++;
        patternIndex++;
        numCharsMatched++;
    }

    private void firstPatternCharMismatchedSetIndexes() {
        textStartingIndex++;
        textIndex = textStartingIndex;
        numCharsMatched = 0;
    }

    private void nextPatternCharMismatchedSetIndexes() {
        int prefix = prefixArray[patternIndex - 1];
        int textIndexShift = patternIndex - prefix;
        textStartingIndex = textStartingIndex + textIndexShift;
        textIndex = textStartingIndex;
        patternIndex = 0;
        numCharsMatched = 0;
    }

    private int[] prefixFunction(String pattern) {
        int[] prefixArray = new int[pattern.length()];
        prefixArray[0] = 0;
        int boundary = 0;
        for (int i = 1; i < pattern.length(); i++) {
            String subString = pattern.substring(0, i + 1);
            boolean firstAndLastCharMatch = subString.charAt(0) == subString.charAt(i);
            if (boundary == 0 && firstAndLastCharMatch) {
                boundary++;
                prefixArray[i] = boundary;
            } else if (boundary > 0 && subString.charAt(boundary) == subString.charAt(i)) {
                boundary++;
                prefixArray[i] = boundary;
            } else if (boundary > 0 && firstAndLastCharMatch)
                prefixArray[i] = boundary;
            else {
                boundary = 0;
            }
        }
        return prefixArray;
    }
}
