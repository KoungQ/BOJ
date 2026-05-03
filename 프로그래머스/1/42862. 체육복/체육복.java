import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            clothes[i] = 1;
        }

        for (int x : lost) {
            clothes[x]--;
        }

        for (int x : reserve) {
            clothes[x]++;
        }

        for (int i = 1; i <= n; i++) {
            if (clothes[i] == 0) {
                if (i > 1 && clothes[i - 1] == 2) {
                    clothes[i]++;
                    clothes[i - 1]--;
                } else if (i < n && clothes[i + 1] == 2) {
                    clothes[i]++;
                    clothes[i + 1]--;
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (clothes[i] >= 1) {
                answer++;
            }
        }

        return answer;
    }
}