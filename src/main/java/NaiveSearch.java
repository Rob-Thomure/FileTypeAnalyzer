public class NaiveSearch implements SearchInterface {

    @Override
    public boolean search(String fileContents, String stringPattern) {
        for (int i = 0; i <= fileContents.length() - stringPattern.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            // inner loop builds substring of file contents to match the size of pattern
            for (int j = 0; j < stringPattern.length(); j++) {
                stringBuilder.append(fileContents.charAt(i + j));
            }
            // if true: found a match and end loop
            if (subStringMatchesPattern(stringBuilder.toString(), stringPattern)) {
                return true;
            }
        }
        // if no match found: return false
        return false;
    }

    private boolean subStringMatchesPattern(String subString, String stringPattern) {
        for (int i = 0; i < subString.length(); i++) {
            if (subString.charAt(i) != stringPattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
