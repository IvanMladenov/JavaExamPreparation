import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine().trim());

        LinkedHashMap<String, TreeMap<String, Integer>> data = new LinkedHashMap<>();

        for (int i = 0; i < numberOfLines; i++) {
            String[] currentLine = scanner.nextLine().split("\\s+");
            String product = currentLine[2];
            String customer = currentLine[0];
            String quantity = currentLine[1];

            if(!data.containsKey(product)) {
                TreeMap<String, Integer> currentValue = new TreeMap<>();
                currentValue.put(customer, Integer.parseInt(quantity));
                data.put(product, currentValue);
            } else {
                if (!data.get(product).containsKey(customer)){
                    data.get(product).put(customer, Integer.parseInt(quantity));
                } else {
                    data.get(product).put(customer, data.get(product).get(customer)+ Integer.parseInt(quantity));
                }
            }
        }

        for (String s : data.keySet()) {
            String outputLine = s+": ";
            //System.out.print(s+": ");
            for (String customer : data.get(s).keySet()) {
                outputLine = outputLine.concat(customer + " " + data.get(s).get(customer) + ", ");
                //System.out.print(customer + " " + data.get(s).get(customer) + ", ");
            }
            System.out.println(outputLine.substring(0, outputLine.length()-2));
        }
    }
}
