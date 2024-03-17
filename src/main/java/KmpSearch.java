import java.util.Arrays;

public class KmpSearch implements SearchInterface {

    @Override
    public boolean search(String fileContents, String patternString) {



        return false;
    }





    

    

    public int[] myPrefixFunction(String pattern) {
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




//    public static void main(String[] args) {
//        KmpSearch searchInterface = new KmpSearch();
//        String pattern = "ABACABB";
//        String pattern2 = "AAAABA";
//        String pattern3 = "MAMMAMIA";
//        int[] prefixArray = searchInterface.myPrefixFunction(pattern3);
//        System.out.println(Arrays.toString(prefixArray));
//
//    }
}
