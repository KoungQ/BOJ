class Solution {
    public int[] solution(int n) {
        
        // 1. 삼각형 만들기
        int[][] tri = new int[n][]; 
        for (int i = 0; i < n; i++) {
            tri[i] = new int[i + 1];
        }

        int x = -1;   // 행 (시작을 -1로 두고 아래로 첫 이동하면서 0이 되게)
        int y = 0;    // 열
        int num = 1;

        // 2. 달팽이 움직이기
        for (int step = 0; step < n; step++) {
            for (int i = step; i < n; i++) {
                if (step % 3 == 0) {          // 아래로
                    x++;
                } else if (step % 3 == 1) {   // 오른쪽으로
                    y++;
                } else {                      // 왼쪽-위 대각선으로
                    x--;
                    y--;
                }
                tri[x][y] = num++;
            }
        }

        // 결과 구하기
        int total = n * (n + 1) / 2;    // 삼각형 너비 (개수)
        int[] answer = new int[total];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = tri[i][j];
            }
        }

        return answer;
    }
}