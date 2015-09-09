import java.util.ArrayList;
import java.util.Scanner;

public class SumCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        input = input.replaceAll("[SHDC]+", " ");
        String[] splitet = input.split("\\s+");

        Integer[] values = new Integer[splitet.length];
        for (int i = 0; i < splitet.length; i++) {
            switch (splitet[i]) {
                case "A":
                    values[i] = 15;
                    break;
                case "K":
                    values[i] = 14;
                    break;
                case "Q":
                    values[i] = 13;
                    break;
                case "J":
                    values[i] = 12;
                    break;
                default:
                    values[i] = Integer.parseInt(splitet[i]);
            }
        }

        int previousValue = values[0];
        ArrayList<Integer> sequence = new ArrayList<>();
        sequence.add(previousValue);
        int finalValue = 0;
        for (int i = 1; i < values.length; i++) {
            Integer value = values[i];
            if (previousValue==value){
                sequence.add(value);
            }else {
                if (sequence.size()>1){
                    finalValue+=previousValue*sequence.size()*2;
                }else {
                    finalValue+=previousValue;
                }

                sequence.clear();
                sequence.add(value);
                previousValue=value;
            }
        }

        if (sequence.size()>1){
            finalValue+=previousValue*sequence.size()*2;
        }else {
            finalValue+=previousValue;
        }

        System.out.println(finalValue);
    }
}
