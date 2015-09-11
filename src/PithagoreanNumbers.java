import java.util.Arrays;
import java.util.Scanner;

public class PithagoreanNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        Integer[] numbers = new Integer[numberOfLines];

        for (int i = 0; i < numberOfLines; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }

        boolean hasResults = false;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                for (int k = 0; k < numbers.length; k++) {
                    boolean isPithagorean = (numbers[i] * numbers[i] + numbers[j] * numbers[j]) == numbers[k] * numbers[k];
                    boolean isSmallOrEqual = numbers[i]<=numbers[j];
                    if (isPithagorean&&isSmallOrEqual){
                        System.out.println(String.format("%1$d*%1$d + %2$d*%2$d = %3$d*%3$d", numbers[i], numbers[j],numbers[k]));
                        hasResults = true;
                    }

                }

            }

        }

        if (!hasResults){
            System.out.println("No");
        }
    }
}
