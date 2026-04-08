class Solution {
    public int solution(String[] arr) {
        int n = arr.length / 2 + 1;

        int[] numbers = new int[n];
        String[] ops = new String[n - 1];

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                numbers[i / 2] = Integer.parseInt(arr[i]);
            } else {
                ops[i / 2] = arr[i];
            }
        }

        int[][] dpMax = new int[n][n];
        int[][] dpMin = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dpMax[i][j] = Integer.MIN_VALUE;
                dpMin[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            dpMax[i][i] = numbers[i];
            dpMin[i][i] = numbers[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                for (int k = i; k < j; k++) {
                    if (ops[k].equals("+")) {
                        dpMax[i][j] = Math.max(dpMax[i][j], dpMax[i][k] + dpMax[k + 1][j]);
                        dpMin[i][j] = Math.min(dpMin[i][j], dpMin[i][k] + dpMin[k + 1][j]);
                    } else {
                        dpMax[i][j] = Math.max(dpMax[i][j], dpMax[i][k] - dpMin[k + 1][j]);
                        dpMin[i][j] = Math.min(dpMin[i][j], dpMin[i][k] - dpMax[k + 1][j]);
                    }
                }
            }
        }

        return dpMax[0][n - 1];
    }
}