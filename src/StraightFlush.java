import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StraightFlush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] cards = scanner.nextLine().split("[,\\s]+");
        if (cards.length<5){
            System.out.println("No Straight Flushes");
            return;
        }

        ArrayList<String[]> allFlushes = new ArrayList<>();
        generateAllFlushes(allFlushes);
        boolean hasFlushes = false;

        for (String[] Flush : allFlushes) {
            int count = 0;
            for (String card : Flush) {
                if (!Arrays.asList(cards).contains(card)){
                    break;
                }
                count++;
            }
            if (count==5){
                System.out.println("["+String.join(", ", Flush)+"]");
                hasFlushes = true;
            }
        }
        if(!hasFlushes){
            System.out.println("No Straight Flushes");
        }
    }

    private static void generateAllFlushes(ArrayList<String[]> allFlushes) {
        char[] suits = {'S', 'H', 'D', 'C'};
        String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (int i = 0; i < suits.length; i++) {
            char suit = suits[i];
            for (int j = 0; j < 9; j++) {
                int startIndex = j;
                int endIndex = j+5;
                String[] currentFlush = new String[5];
                for (int k = startIndex, counter=0; k < endIndex; k++, counter++) {
                    currentFlush[counter] = faces[k] + suit;
                }
                allFlushes.add(currentFlush);
            }
        }
    }
}
