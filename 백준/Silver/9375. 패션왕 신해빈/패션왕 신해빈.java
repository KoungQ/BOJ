import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            int testCase = sc.nextInt();

            for(int i = 0; i < testCase; i++) {
                int clothNum = sc.nextInt();
                sc.nextLine();

                Map<String, List<String>> cloths = new HashMap<>();
                for(int j = 0; j < clothNum; j++) {
                    String cloth = sc.next();
                    String kind = sc.next();

                    sc.nextLine();

                    if(!cloths.containsKey(kind)) {
                        List<String> clothToList = new ArrayList<>();
                        clothToList.add(cloth);

                        cloths.put(kind, clothToList);
                    }
                    else
                        cloths.get(kind).add(cloth);
                }

                int result = 1;

                for (List<String> value : cloths.values()) {
                    result *= (value.size() + 1);
                }
                System.out.println(result - 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
