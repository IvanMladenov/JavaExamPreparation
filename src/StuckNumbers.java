import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class StuckNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        String[] inputLine = scanner.nextLine().split("\\s+");

        ArrayList<String> numbersWithPipe = new ArrayList<>();
        ArrayList<String> stuckNumbers = new ArrayList<>();

        for (int i = 0; i < inputLine.length; i++) {
            for (int j = 0; j < inputLine.length; j++) {
                if (i == j) {
                    continue;
                }
                numbersWithPipe.add(inputLine[i] + "|" + inputLine[j]);
                stuckNumbers.add(inputLine[i] + inputLine[j]);
            }
        }

        boolean hasOutput = false;
        for (int i = 0; i < stuckNumbers.size(); i++) {
            for (int j = 0; j < stuckNumbers.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (stuckNumbers.get(i).equals(stuckNumbers.get(j))) {
                    String[] leftSide = numbersWithPipe.get(i).split("\\|");
                    String[] rightSide = numbersWithPipe.get(j).split("\\|");
                    HashSet<String> checkForDiff = new HashSet<>();
                    checkForDiff.add(leftSide[0]);
                    checkForDiff.add(leftSide[1]);
                    checkForDiff.add(rightSide[0]);
                    checkForDiff.add(rightSide[1]);
                    if (checkForDiff.size() == 4) {
                        System.out.println(numbersWithPipe.get(i) + "==" + numbersWithPipe.get(j));
                        hasOutput = true;
                    }
                }
            }
        }

        if (hasOutput==false) {
            System.out.println("No");
        }
    }
}
