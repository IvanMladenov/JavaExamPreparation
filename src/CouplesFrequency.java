import java.util.LinkedHashMap;
import java.util.Scanner;

public class CouplesFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");
        LinkedHashMap<String, Integer> couples = new LinkedHashMap<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            String mapKey = numbers[i]+" "+numbers[i+1];
            if (!couples.containsKey(mapKey)){
                couples.put(mapKey, 1);
            }else {
                Integer newValue = couples.get(mapKey)+1;
                couples.put(mapKey, newValue);
            }
        }

        for (String couple : couples.keySet()) {
            Double percentage = (couples.get(couple)/((double)numbers.length-1))*100;

            System.out.printf("%s -> %.2f%%", couple, percentage);
            System.out.println();
        }
    }
}
