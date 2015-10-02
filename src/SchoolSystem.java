import java.util.*;

public class SchoolSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        TreeMap<String, TreeMap<String, ArrayList<Double>>> data = new TreeMap<>();

        for (int i = 0; i < numberOfLines; i++) {
            String currentLine = scanner.nextLine().trim();
            String[] splitetElements = currentLine.split("\\s+");

            String studentName = splitetElements[0] + " " + splitetElements[1];
            String subject = splitetElements[2];
            Double score = Double.parseDouble(splitetElements[3]);

            if ((!data.containsKey(studentName))){
                data.put(studentName, new TreeMap<>());
                data.get(studentName).put(subject, new ArrayList<>());
                data.get(studentName).get(subject).add(score);
            }else {
                if (data.get(studentName).containsKey(subject)){
                    data.get(studentName).get(subject).add(score);
                }else {
                    data.get(studentName).put(subject, new ArrayList<>());
                    data.get(studentName).get(subject).add(score);
                }
            }
        }

        for (String name : data.keySet()) {
            System.out.print(name + ": ");
            LinkedList<String> subjectsScore = new LinkedList<>();
            for (String subj : data.get(name).keySet()) {
                Double avgScore = 0.0;
                for (Double score : data.get(name).get(subj)) {
                    avgScore+=score;
                }
                avgScore = avgScore/data.get(name).get(subj).size();
                String current = String.format("%s - %.2f", subj, avgScore);
                subjectsScore.add(current);
            }
            System.out.println(subjectsScore);
        }
    }
}
