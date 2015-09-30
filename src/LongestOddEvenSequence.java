import java.util.Scanner;

public class LongestOddEvenSequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine().trim().replaceAll("[()]", " ");
        String[] numbersSplitet = inputLine.split("\\s+");
        Integer[] numbers = new Integer[numbersSplitet.length-1];

        for (int i = 1; i < numbersSplitet.length; i++) {
            numbers[i-1] = Integer.parseInt(numbersSplitet[i]);
        }

        int maxLenght = 0;

        for (int i = 0; i < numbers.length; i++) {
            int currentSequenceLenght = 1;
            int previousNumber = numbers[i];
            for (int j = i+1; j < numbers.length; j++) {
                if (previousNumber==0){
                    currentSequenceLenght++;
                    previousNumber=numbers[j];
                    continue;
                }

                if (numbers[j]==0){
                    currentSequenceLenght++;
                    previousNumber=0;

                }else if (numbers[j]%2 != previousNumber%2){
                    currentSequenceLenght++;
                    previousNumber=numbers[j];

                }else {
                    break;
                }
            }

            if (currentSequenceLenght>maxLenght){
                maxLenght=currentSequenceLenght;
            }
        }

        System.out.println(maxLenght);
    }
}
