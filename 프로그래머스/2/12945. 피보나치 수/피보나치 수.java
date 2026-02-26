class Solution {
    int[] dp;

    public int solution(int n) {
        dp = new int[n + 1];
        return fibo(n);
    }

    int fibo(int n) {
        if (n == 2) 
            return 1;
        if (n == 3) 
            return 2;

        if (dp[n] != 0) 
            return dp[n];

        dp[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
        return dp[n];
    }
}