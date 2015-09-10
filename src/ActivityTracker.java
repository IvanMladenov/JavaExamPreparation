import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.TreeMap;

public class ActivityTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputLines = Integer.parseInt(scanner.nextLine());
        TreeMap<Integer, TreeMap<String, Double>> data = new TreeMap<>();

        for (int i = 0; i < numberOfInputLines; i++) {
            String currentLine = scanner.nextLine();
            String[] lineSplitet = currentLine.split("\\s+");
            String[] dateSplitet = lineSplitet[0].split("/");

            int month = Integer.parseInt(dateSplitet[1]);
            String name = lineSplitet[1];
            double distance = Double.parseDouble(lineSplitet[2]);

            if (!data.containsKey(month)) {
                data.put(month, new TreeMap<>());
            }
            if (!data.get(month).containsKey(name)) {
                data.get(month).put(name, distance);
            } else {
                Double currentValue = data.get(month).get(name);
                data.get(month).put(name, currentValue + distance);
            }
        }

        for (Integer integer : data.keySet()) {
            System.out.print(integer+": ");
            String outputLine = "";
            for (String name : data.get(integer).keySet()) {
                DecimalFormat df = new DecimalFormat("0.#");
                outputLine+=String.format("%s(%s), ", name, df.format(data.get(integer).get(name)));
            }
            System.out.println(outputLine.substring(0, outputLine.length()-2));
        }
    }
}
