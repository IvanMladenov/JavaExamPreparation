import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class OfficeStuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, LinkedHashMap<String, ArrayList<Integer>>> data = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().trim().split("[- |]+");
            String company = input[1];
            String product = input[3];
            Integer amount = Integer.parseInt(input[2]);

            if (!data.containsKey(company)){
                data.put(company, new LinkedHashMap<>());
                data.get(company).put(product, new ArrayList<>());
                data.get(company).get(product).add(amount);
            } else {
                if (data.get(company).containsKey(product)){
                    data.get(company).get(product).add(amount);
                }else {
                    data.get(company).put(product, new ArrayList<>());
                    data.get(company).get(product).add(amount);
                }
            }
        }

        for (String comp : data.keySet()) {
            System.out.print(comp + ": ");
            ArrayList<String> output = new ArrayList<>();
            for (String prod : data.get(comp).keySet()) {
                int totalAmount = 0;
                for (Integer amoun : data.get(comp).get(prod)) {
                    totalAmount+=amoun;
                }
                String current = prod + "-" + totalAmount;
                output.add(current);
            }
            System.out.println(String.join(", ", output));
        }
    }
}
