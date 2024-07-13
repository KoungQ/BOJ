package BOJ.일곱난쟁이_2309;

import java.util.*;

// 내 풀이 2
public class Solution_v2 {
    static List<Integer> dwarfs = new ArrayList<>();
    static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            dwarfs.add(sc.nextInt());
            sum += dwarfs.get(i);
        }

        Collections.sort(dwarfs);
        solution(0, 1);
        for (Integer dwarf : dwarfs) {
            System.out.println(dwarf);
        }
    }

    static void solution(int idx1, int idx2) {
        if (dwarfs.size() == 7)
            return;

        if (dwarfs.get(idx1) + dwarfs.get(idx2) == sum - 100) {
            dwarfs.remove(idx1);
            dwarfs.remove(idx2 - 1);
        }

        if (idx2 > dwarfs.size() - 2)
            if (idx1 <= dwarfs.size() - 1)
                solution(idx1 + 1, idx1 + 2);
        solution(idx1, idx2 + 1);
    }
}
