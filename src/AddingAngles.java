import java.util.Scanner;

public class AddingAngles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String[] angles = scanner.nextLine().split("\\s+");
        Integer[] degrees = new Integer[angles.length];

        for (int i = 0; i < angles.length; i++) {
            degrees[i] = Integer.parseInt(angles[i]);
        }

        boolean hasResult = false;
        for (int i = 0; i < degrees.length - 2; i++) {
            for (int j = i + 1; j < degrees.length - 1; j++) {
                for (int k = j + 1; k < degrees.length; k++) {
                    Integer currentSum = degrees[i] + degrees[j] + degrees[k];

                    if (currentSum % 360 == 0) {
                        System.out.printf("%d + %d + %d = %d degrees\n",
                                degrees[i],
                                degrees[j],
                                degrees[k],
                                currentSum);
                        hasResult = true;
                    }
                }
            }
        }

        if (hasResult == false) {
            System.out.println("No");
        }
    }
}
