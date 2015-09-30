import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ThreeLargestNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numbersCount = Integer.parseInt(scanner.nextLine().trim());

        BigDecimal[] numbers = new BigDecimal[numbersCount];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new BigDecimal(scanner.nextLine());

        }
        Arrays.sort(numbers, Collections.reverseOrder());
        int endPoint;

        if (numbersCount>=3){
            endPoint=3;
        }else {
            endPoint=numbersCount;
        }

        for (int i = 0; i < endPoint; i++) {
            if(i==numbersCount){
                break;
            }
            System.out.println(numbers[i].toPlainString());
        }
    }
}
