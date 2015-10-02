import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine().trim();

        TreeMap<String, LinkedHashMap<String, Integer>> data = new TreeMap<>();
        while (!inputLine.equals("end")){
            String[] elements = inputLine.split("\\s+");
            String[] ipLog = elements[0].split("=");
            String[] usernameLog = elements[2].split("=");

            String ip = ipLog[1];
            String username = usernameLog[1];

            if (!data.containsKey(username)){
                data.put(username, new LinkedHashMap<>());
                data.get(username).put(ip, 1);
            }else {
                if (data.get(username).containsKey(ip)){
                    int oldValue = data.get(username).get(ip);
                    data.get(username).put(ip, oldValue+1);
                }else {
                    data.get(username).put(ip, 1);
                }
            }

            inputLine = scanner.nextLine().trim();
        }

        for (String username : data.keySet()) {
            System.out.println(username + ":");
            List<String> ipOutput = new LinkedList<>();
            for (String ip : data.get(username).keySet()) {
                String currentLine =  ip + " => " + data.get(username).get(ip);
                ipOutput.add(currentLine);
            }

            for (int i = 0; i < ipOutput.size(); i++) {
                if (i<ipOutput.size()-1){
                    System.out.print(ipOutput.get(i)+", ");
                }else {
                    System.out.println(ipOutput.get(i)+'.');
                }
            }
        }
    }
}
