import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;

        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        while (visited.size() < n) {
            int[] path = null;

            for (int i = 0; i < costs.length; i++) {
                int a = costs[i][0];
                int b = costs[i][1];

                boolean canGo =
                    (visited.contains(a) && !visited.contains(b)) ||
                    (visited.contains(b) && !visited.contains(a));

                if (!canGo) {
                    continue;
                }

                if (path == null || costs[i][2] < path[2]) {
                    path = costs[i];
                }
            }

            int a = path[0];
            int b = path[1];

            if (visited.contains(a)) {
                visited.add(b);
            } else {
                visited.add(a);
            }

            answer += path[2];
        }

        return answer;
    }
}