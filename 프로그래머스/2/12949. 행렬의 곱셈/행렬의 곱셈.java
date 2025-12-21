class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;        // arr1 행
        int c1 = arr1[0].length;     // arr1 열 == arr2 행
        int c2 = arr2[0].length;     // arr2 열

        int[][] answer = new int[r1][c2];

        // 계산
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                int sum = 0;
                for (int k = 0; k < c1; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }

        return answer;
    }
}
