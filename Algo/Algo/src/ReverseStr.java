

public class ReverseStr {
    public static void main(String[] args) {
        String str = "Civic is a good car";
        System.out.println(reverseString(str, true));
        System.out.println(reverseString(str, false));
    }

    /**
     * This method returns the reverse String of the given String, it also supports if the word reverse is required or the
     * entire string.
     * EX. input str = Civic is a good car
     * If boolean is TRUE -> civiC si a doog rac
     * else -> rac doog a si civiC
     *
     * @Param - String (string to be reversed), boolean (is word required to be reversed)
     * @return String
     */
    private static String reverseString(String str, boolean isWordReverse) {
        StringBuilder stringBuilder = new StringBuilder();

        if(!isWordReverse) {
            for (int i = str.length() - 1; i >= 0; i--) {
                stringBuilder.append(str.charAt(i));
            }
            return stringBuilder.toString();
        }

        for (String s : str.split("\\s")) {
            stringBuilder.append(reverseString(s, false)).append(" ");
        }
        return stringBuilder.toString();
    }
}
