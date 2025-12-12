import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] T = new int[N + 2];
        int[] P = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 3];

        for (int i = N; i >= 1; i--) {
            int next = i + T[i];
            dp[i] = dp[i + 1];
            if (next <= N + 1) {
                dp[i] = Math.max(dp[i], P[i] + dp[next]);
            }
        }

        System.out.println(dp[1]);
    }
}
