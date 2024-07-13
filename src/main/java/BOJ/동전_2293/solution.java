package BOJ.동전_2293;

import java.util.Scanner;

public class solution {

    static int[] dp = new int[10004];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        dp[0] = 1;
        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();

            for(int j = temp; j <= k; j++) {
                dp[j] += dp[j - temp];
            }
        }

        System.out.println(dp[k]);
    }
}
