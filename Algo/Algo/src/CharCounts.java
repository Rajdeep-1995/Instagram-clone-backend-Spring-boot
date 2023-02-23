import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class CharCounts {

    public static void main(String[] args) {
        String randomStr = "jdwjdjHihdiihnkNkjkjkjKknk";
        System.out.println(getCharCounts(randomStr));
    }

    private static Map<Character, Integer> getCharCounts(String randomStr) {
        Map<Character,Integer> charCount = new HashMap<>();

        for (int i=0; i<randomStr.length(); i++) {
            Character c = randomStr.charAt(i);
            if(charCount.containsKey(c)) {
                Integer count = charCount.get(c);
                charCount.put(c, ++count);
            } else {
                charCount.put(c, 1);
            }
        }
        return charCount;
    }
}
