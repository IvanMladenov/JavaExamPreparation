import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class LegoBlocks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        LinkedList<int[]> firstBlock = new LinkedList<>();
        LinkedList<int[]> secondBlock = new LinkedList<>();
        int totalCellsCount = 0;

        for (int i = 0; i < numberOfLines; i++){
            String[] currentLine = scanner.nextLine().trim().split("\\s+");
            int[] currentNumbers = Arrays.stream(currentLine).mapToInt(Integer::parseInt).toArray();
            totalCellsCount+=currentNumbers.length;
            firstBlock.add(currentNumbers);
        }

        for (int i = 0; i < numberOfLines; i++){
            String[] currentLine = scanner.nextLine().trim().split("\\s+");
            int[] currentNumbers = Arrays.stream(currentLine).mapToInt(Integer::parseInt).toArray();
            totalCellsCount+=currentNumbers.length;
            secondBlock.add(currentNumbers);
        }

        int etalon = firstBlock.get(0).length + secondBlock.get(0).length;

        for (int i = 1; i < numberOfLines; i++) {
            int currentLenght = firstBlock.get(i).length + secondBlock.get(i).length;

            if (currentLenght != etalon){
                System.out.println("The total number of cells is: " + totalCellsCount);
                return;
            }
        }

        for (int i = 0; i < numberOfLines; i++) {
            String output = GenerateOutputLine(firstBlock.get(i), secondBlock.get(i));
            System.out.println(output);
        }
    }

    private static String GenerateOutputLine(int[] first, int[] second) {
        String output = "[";
        int[] reversed = reverseArray(second);
        for (int i = 0; i < first.length; i++) {
            output += first[i] + ", ";
        }

        for (int i = 0; i < reversed.length; i++) {
            if (i != reversed.length-1){
                output += reversed[i] + ", ";
            }else {
                output += reversed[i];
            }
        }

        return output + "]";
    }

    private static int[] reverseArray(int[] second) {
        int[] reversed = new int[second.length];

        for (int i = 0; i < reversed.length; i++) {
            reversed[second.length-1-i] = second[i];
        }
        return reversed;
    }
}
