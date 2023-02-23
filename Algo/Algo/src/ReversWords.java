import java.util.Arrays;

public class ReversWords {
    public static void main(String[] args) {
        String str =  "  the sky is          blue       ";

        System.out.println(reverseWords(str));
    }

    private static String reverseWords(String s) {
        StringBuilder strBld = new StringBuilder();
        String trimStr = s.trim();
        int trackArrLength = trimStr.split("\\s").length;
        int lengthOfFullString = trimStr.length() - 1;

            String[] wordArr = trimStr.split("\\s");
            while (lengthOfFullString>=0) {
                while (trackArrLength != 0 && !wordArr[--trackArrLength].isEmpty()) {
                    strBld.append(wordArr[trackArrLength]);
                    if (trackArrLength != 0) {
                        strBld.append(" ");
                    }
                }
                lengthOfFullString--;
            }
            return strBld.toString();
    }
}
