import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        long[] h = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) h[i] = Long.parseLong(st.nextToken());

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int cnt = 0;

            double maxSlope = -Double.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                double s = (double)(h[j] - h[i]) / (j - i);
                if (s > maxSlope) {
                    maxSlope = s;
                    cnt++;
                }
            }

            double minSlope = Double.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                double s = (double)(h[j] - h[i]) / (j - i);
                if (s < minSlope) {
                    minSlope = s;
                    cnt++;
                }
            }

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}
