import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/*
   Bubble sort algorithm to sort the values in order, low to high.
   Time space complexity o(n^2);
 */
public class BubbleSort {
    public static void main(String[] args) {

        Random random = new Random();
        int[] randNumbers = new int[10];

        for (int i = 0; i < randNumbers.length; i++) {
            randNumbers[i] = random.nextInt(200);
        }

        System.out.println("-----BEFORE------");
        printArray(randNumbers);
        System.out.println();
        System.out.println("-----AFTER------");
        System.out.println();
        printArray(bubbleSort(randNumbers));
    }
    public static void printArray(int[] arr) {
        Arrays.stream(arr).forEach(System.out::println);
    }
    public static int[] bubbleSort(int[] intArray) {
        boolean swapRequire = true;

        while (swapRequire) {
            swapRequire = false;
            for (int i = 0; i < intArray.length - 1; i++) {
                /**
                   Array of N elements = [5,4,7,8,3]
                   If the Nth element is grater than Nth+1 element (5>4) swap the values with each other
                 */
                if(intArray[i] > intArray[i+1]) {
                    swapRequire = true;
                    int temp = intArray[i];
                    intArray[i] = intArray[i+1];
                    intArray[i+1] = temp;
                }
            }
        }
        return intArray;
    }
}
