import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Scanner;

public class HundredDays {

    public static void main(String[] args) {
        System.out.println("Please enter a number to get the date...");
        Scanner scanner = new Scanner(System.in);

        System.out.println(nthDaysFromNow(scanner.nextInt()));
    }

    private static LocalDate nthDaysFromNow(int days) {
        LocalDate today = LocalDate.now();

        return today.plusDays(days);
    }
}
