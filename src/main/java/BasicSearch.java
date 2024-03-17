public class BasicSearch implements SearchInterface {

    @Override
    public boolean search(String fileContents, String stringPattern) {
        return fileContents.contains(stringPattern);
    }
}
