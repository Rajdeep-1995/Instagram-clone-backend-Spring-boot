import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniqueValuesFrom2Arrays {
    public static String[] uniqueArr(String[] names1, String[]
            names2)
    {
        Set<String> set = new HashSet<>(new
                LinkedList<>(Stream.of(names1,
                names2).flatMap(Stream::of).collect(Collectors.toList())));
        String[] arr = new String[set.size()];
        set.toArray(arr);
        return arr;
    }

    public static void main(String[] args) {
        String[] arr1 = {"Raj","John","John"};
        String[] arr2 = {"Doe","Jerry","Bill","Raj","Doe"};

        Arrays.stream(uniqueArr(arr1,arr2)).forEach(System.out::println);
    }
}
