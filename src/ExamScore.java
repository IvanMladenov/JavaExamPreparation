import java.util.*;

public class ExamScore {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         scanner.nextLine();
         scanner.nextLine();
         scanner.nextLine();

         String input = scanner.nextLine();
         TreeMap<Integer, TreeMap<String, Double>> data = new TreeMap<>();
         while (!input.contains("-----")){
             String[] splitet = input.split("[|]+");
             int score = Integer.parseInt(splitet[2].trim());
             String name = splitet[1].trim();
             Double grade = Double.parseDouble(splitet[3].trim());

             if (!data.containsKey(score)){
                 data.put(score, new TreeMap<>());
             }
             data.get(score).put(name, grade);

             input = scanner.nextLine();
         }

         for (Integer score : data.keySet()) {
             System.out.print(score + " -> ");
             ArrayList<String> names = new ArrayList<>();
             Double grades = 0.0;
             for (String name : data.get(score).keySet()) {
                 names.add(name);
                 grades += data.get(score).get(name).doubleValue();
             }
             System.out.print(names);
             Double avgGrade = grades/names.size();
             System.out.printf("; avg=%.2f\n", avgGrade);
         }
     }
}
