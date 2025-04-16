import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int n, m;
        String s;
        Map<String, Integer> mp1 = new HashMap<>();
        Map<Integer, String> mp2 = new HashMap<>();
        String[] a = new String[100004];

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i <= n; i++) {
            s = sc.nextLine();
            mp1.put(s, i + 1);
            mp2.put(i + 1, s);
            a[i + 1] = s;
        }

        for(int i = 0; i < m; i++) {
            s = sc.nextLine();
            if(s.matches("[0-9]+")) {   
                System.out.println(mp2.get(Integer.parseInt(s) + 1));
            } else {
                System.out.println(mp1.get(s) - 1);
            }
        }
    }
}
