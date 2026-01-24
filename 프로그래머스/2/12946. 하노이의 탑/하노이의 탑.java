class Solution {
    int idx = 0;
    int[][] answer;

    public int[][] solution(int n) {
        int moveCount = (1 << n) - 1;   // 2^n - 1
        answer = new int[moveCount][2];

        hanoi(n, 1, 2, 3);
        return answer;
    }

    private void hanoi(int n, int from, int via, int to) {
        if (n == 0) 
            return;

        // 위에 치우고
        hanoi(n - 1, from, to, via);

        // 가장 큰거 옮기고
        answer[idx][0] = from;
        answer[idx][1] = to;
        idx++;

        // 다시 쌓기
        hanoi(n - 1, via, from, to);
    }
}