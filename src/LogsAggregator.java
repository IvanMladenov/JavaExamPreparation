import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputLines = Integer.parseInt(scanner.nextLine());

        TreeMap<String, TreeSet<String>> nameIpMap = new TreeMap<>();
        TreeMap<String, ArrayList<Integer>> nameDurationMap = new TreeMap<>();

        for (int i = 0; i < numberOfInputLines; i++) {
            String[] inputSplitet = scanner.nextLine().split("[\\s+]");
            if (!nameIpMap.containsKey(inputSplitet[1])){
                nameIpMap.put(inputSplitet[1], new TreeSet<>());
                nameDurationMap.put(inputSplitet[1], new ArrayList<>());
            }

            nameIpMap.get(inputSplitet[1]).add(inputSplitet[0]);
            nameDurationMap.get(inputSplitet[1]).add(Integer.parseInt(inputSplitet[2]));
        }

        for (String name : nameDurationMap.keySet()) {
            Integer totalDuration = 0;
            for (Integer number : nameDurationMap.get(name)) {
                totalDuration+=number;
            }

            System.out.println(name+": "+totalDuration+" "+nameIpMap.get(name));
        }
    }
}
