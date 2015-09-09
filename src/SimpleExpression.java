import java.math.BigDecimal;
import java.util.Scanner;

public class SimpleExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine().replaceAll("\\s+", "");


        String[] numbers = expression.split("[+-]");
        String[] signs = expression.split("[^+-]+");
        BigDecimal result = new BigDecimal(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            for (int j = 1; j < signs.length; j++) {
                if (signs[j].equals("-")) {
                    result = result.subtract(new BigDecimal(numbers[i]));
                    signs[j] = "";
                    break;
                } else if (signs[j].equals("+")) {
                    result = result.add(new BigDecimal(numbers[i]));
                    signs[j] = "";
                    break;
                }
            }
        }

        System.out.printf("%.7f", result);
    }
}
