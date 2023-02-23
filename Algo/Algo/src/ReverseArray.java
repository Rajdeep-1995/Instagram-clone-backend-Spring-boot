import hashcodeandequals.Person;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseArray {

    public static void main(String[] args) {
        String[] cars ={"Civic", "Toyota","Hyundai","KIA","Mazda","Ford"};
        Integer[] numbers = {1,2,6,7,54,3,7,9,3,2,6};
        Person[] names = {
                new Person("Raj",30),
                new Person("Nidz",25),
                new Person("John",31),
                new Person("Doe",34)
        };

        System.out.println(Arrays.toString(reverseArray(cars)));
        System.out.println(Arrays.toString(reverseArray(numbers)));
        System.out.println(Arrays.toString(reverseArray(names)));

    }

    private static <T> T[] reverseArray(T[] inputArr) {
        if (inputArr.length==0) throw new RuntimeException("Array should not be empty!");

        for (int i = 0; i < inputArr.length/2; i++) {
            T currentIndexValue = inputArr[i];
            inputArr[i] = inputArr[inputArr.length-i-1];
            inputArr[inputArr.length-i-1] = currentIndexValue;
        }
        return inputArr;
    }
}
