import java.util.*;

public class Biggest3PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().trim();
        String[] splitet = input.split("[)(\\s]+");
        TreeSet<Integer> uniqueNumbers = new TreeSet<>(Collections.reverseOrder());

        for (int i = 1; i < splitet.length; i++) {
            Integer currentNumber = Integer.parseInt(splitet[i]);
            if (currentNumber > 0) {
                uniqueNumbers.add(currentNumber);
            }
        }

        ArrayList<Integer> primeNumbersToHundred = new ArrayList<>();
        generatePrimeNumber(primeNumbersToHundred);

        int sum = 0;
        int count = 0;
        for (Integer uniqueNumber : uniqueNumbers) {
            if (primeNumbersToHundred.contains(uniqueNumber)) {
                sum += uniqueNumber;
                count++;
            }
            if (count == 3) {
                break;
            }
        }

        if (count == 3) {
            System.out.println(sum);
        } else {
            System.out.println("No");
        }

    }

    private static void generatePrimeNumber(ArrayList<Integer> primeNumbersToHundred) {
        primeNumbersToHundred.add(2);
        primeNumbersToHundred.add(3);
        primeNumbersToHundred.add(5);

        for (int i = 6; i < 99; i++) {
            int counter = 0;
            for (Integer integer : primeNumbersToHundred) {
                if (i % integer == 0) {
                    break;
                }
                counter++;
            }

            if (counter == primeNumbersToHundred.size()) {
                primeNumbersToHundred.add(i);
            }
        }
    }
}
