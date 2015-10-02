import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Weightlifting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, TreeMap<String, ArrayList<Integer>>> data = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputElements = scanner.nextLine().trim().split("\\s+");

            String player = inputElements[0];
            String exercise = inputElements[1];
            Integer weight = Integer.parseInt(inputElements[2]);

            if(!data.containsKey(player)){
                data.put(player, new TreeMap<>());
                data.get(player).put(exercise, new ArrayList<>());
                data.get(player).get(exercise).add(weight);
            }else {
                if (data.get(player).containsKey(exercise)){
                    data.get(player).get(exercise).add(weight);
                }else {
                    data.get(player).put(exercise, new ArrayList<>());
                    data.get(player).get(exercise).add(weight);
                }
            }
        }

        for (String name : data.keySet()) {
            String outputLine = name + " : ";
            ArrayList<String> allOutput = new ArrayList<>();
            for (String category : data.get(name).keySet()) {
                String current = category + " - " + calculateTotalWeight(data.get(name).get(category));
                allOutput.add(current);
            }
            System.out.println(outputLine + String.join(", ", allOutput));
        }
    }

    private static String calculateTotalWeight(ArrayList<Integer> integers) {
        long totalWeight = 0;
        for (Integer integer : integers) {
            totalWeight+=integer;
        }

        return totalWeight + " kg";
    }
}
