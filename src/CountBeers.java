import java.util.Scanner;

public class CountBeers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String inputLine = sc.nextLine().trim();
        Integer totalBeers = 0;

        while (!inputLine.equals("End")){

            String[] elements = inputLine.split("\\s+");

            switch (elements[1]){
                case "stacks":
                    totalBeers+= Integer.parseInt(elements[0])*20;
                    break;
                case "beers":
                    totalBeers += Integer.parseInt(elements[0]);
                    break;
            }

            inputLine = sc.nextLine().trim();
        }

        Integer totalStacks = totalBeers/20;
        Integer totalSingleBottles = totalBeers%20;

        System.out.printf("%d stacks + %d beers", totalStacks, totalSingleBottles);
    }
}
