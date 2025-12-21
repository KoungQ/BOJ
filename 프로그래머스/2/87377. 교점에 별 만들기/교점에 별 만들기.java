import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        
        int n = line.length;
        Set<long[]> points = new HashSet<>();   // 같은 점 불필요 연산 제거

        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;

        // 1. 모든 직선 쌍의 교점 구하기
        for (int i = 0; i < n - 1; i++) {
            long A = line[i][0];
            long B = line[i][1];
            long C = line[i][2];

            for (int j = i + 1; j < n; j++) {
                long D = line[j][0];
                long E = line[j][1];
                long F = line[j][2];

                long denom = A * E - B * D; // 분모
                if (denom == 0) continue;   // 교점 X -> continue

                long xNum = B * F - C * E;  // 분자 x
                long yNum = C * D - A * F;  // 분모 y

                if (xNum % denom != 0 || yNum % denom != 0)
                    continue;   // 나누어 떨어질때만

                long x = xNum / denom;
                long y = yNum / denom;

                points.add(new long[]{x, y});

                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
        }

        // 2. 격자 생성
        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);

        char[][] grid = new char[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(grid[i], '.');
        }

        // 3. 별 찍기
        for (long[] p : points) {
            int col = (int) (p[0] - minX);
            int row = (int) (maxY - p[1]);
            grid[row][col] = '*';
        }

        // 4. answer 채우기
        answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(grid[i]);
        }
        
        return answer;
    }
}