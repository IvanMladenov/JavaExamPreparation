import java.math.BigDecimal;
import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine().trim();
        String[] splitetStrings = inputLine.split("\\s+");
        Double finalSum = 0.0;

        for (String splitetString : splitetStrings) {
            Double currentSum = 0.0;

            Double number = Double.parseDouble(splitetString.substring(1, splitetString.length() - 1));
            currentSum = number;
            Character begining = splitetString.charAt(0);
            Character end = splitetString.charAt(splitetString.length()-1);

            if (Character.isUpperCase(begining)){
                Integer upperPosition = (int)(begining) - 64;
                currentSum = currentSum/upperPosition;
            }else {
                Integer lowerPosition = (int)(begining) - 96;
                currentSum = currentSum*lowerPosition;
            }

            if (Character.isUpperCase(end)){
                Integer upperPosition = (int)(end) - 64;
                currentSum -= upperPosition;
            }else {
                Integer lowerPosition = (int)(end) - 96;
                currentSum += lowerPosition;
            }

            finalSum += currentSum;
        }

        System.out.printf("%.2f", finalSum);
    }
}
