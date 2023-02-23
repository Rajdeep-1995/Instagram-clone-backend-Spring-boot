import java.util.Arrays;
import java.util.Scanner;

public class FibonacciSeries {

    private static long[] fibonacciCache;
    public static void main(String[] args) {
        System.out.println("Please enter max limit to generate Fibonacci sequence:");
        Scanner scanner = new Scanner(System.in);

        int maxLimit = scanner.nextInt();
        fibonacciCache = new long[maxLimit+1];

        System.out.println("The generated sequence is as follow ->");
        System.out.println();

        for (int i = 0; i <= maxLimit; i++) {
            System.out.println(fibonacci(i));
        }
    }

    private static long fibonacci(int n) {
        if(n <= 1) return n;

        if(fibonacciCache[n] != 0) return fibonacciCache[n];

        long fibonacciNth = fibonacci(n-1) + fibonacci(n-2);
        fibonacciCache[n] = fibonacciNth;
        return fibonacciNth;
    }

}
