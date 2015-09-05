import java.util.HashSet;
import java.util.Scanner;

public class CognateWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] elements = input.split("[^A-Za-z]+");
        HashSet<String> output = new HashSet<>();

        for (int i = 0; i < elements.length - 1; i++) {
            for (int j = i + 1; j < elements.length; j++) {
                String currentPair = elements[i] + elements[j];
                String reversedPair = elements[j] + elements[i];

                for (int k = 0; k < elements.length; k++) {

                    if (elements[k].equals(currentPair)) {
                        output.add(String.format("%s|%s=%s", elements[i], elements[j], elements[k]));
                    } else if (elements[k].equals(reversedPair)) {
                        output.add(String.format("%s|%s=%s", elements[j], elements[i], elements[k]));
                    }
                }

            }

        }
        if (output.isEmpty()) {
            System.out.println("No");
        } else {
            System.out.println(String.join("\n", output));
        }
    }
}
