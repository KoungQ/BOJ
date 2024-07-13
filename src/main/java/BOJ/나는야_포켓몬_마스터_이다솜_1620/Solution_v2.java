package BOJ.나는야_포켓몬_마스터_이다솜_1620;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Array를 쓰면 시간 초과지만 Map을 사용하면 성공하는 이유 :
 *          Array는 iterator로 탐색할 때 시간 복잡도가 O(n) 이지만
 *          Map은 .get(key)로 찾을 때 시간 복잡도가 O(log n) 이라서 더 빠르게 탐색할 수 있다.
 */
public class Solution_v2 {
    public static void main(String[] args) {
        int n, m;
        String s;
        Map<String, Integer> mp1 = new HashMap<>();
        Map<Integer, String> mp2 = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i <= n; i++) {
            s = sc.nextLine();
            mp1.put(s, i + 1);
            mp2.put(i + 1, s);
        }

        for(int i = 0; i < m; i++) {
            s = sc.nextLine();
            if(s.matches("[0-9]+")) {   // 숫자라면 mp2 사용
                System.out.println(mp2.get(Integer.parseInt(s) + 1));
            } else {
                System.out.println(mp1.get(s) - 1);
            }
        }
    }
}
