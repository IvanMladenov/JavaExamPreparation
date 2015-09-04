import java.util.Scanner;

public class DozensOfEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine;

        int dozensCount = 0;
        int eggsCount = 0;
        for (int i = 0; i < 7; i++) {
            inputLine = scanner.nextLine();
            String[] inputArgs = inputLine.split(" ");

            switch (inputArgs[1]) {
                case "eggs":
                    eggsCount += Integer.parseInt(inputArgs[0]);
                    break;
                case "dozens":
                    dozensCount += Integer.parseInt(inputArgs[0]);
                    break;
            }
        }

        dozensCount += (eggsCount / 12);
        eggsCount = eggsCount % 12;

        System.out.printf("%d dozens + %d eggs", dozensCount, eggsCount);
    }
}
