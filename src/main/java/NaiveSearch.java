public class NaiveSearch implements SearchInterface {

    @Override
    public boolean search(String fileContents, String searchString) {
        for (int i = 0; i < (fileContents.length() - searchString.length() + 1); i++) {
            for (int j = 0; j < searchString.length(); j++) {
                if (searchString.charAt(j) != fileContents.charAt(i + j)) {
                    break;
                } else if (searchString.charAt(j) == fileContents.charAt(i + j) && j == searchString.length() - 1) {
                    return true;
                }
            }
        }
        return false;
    }


}
