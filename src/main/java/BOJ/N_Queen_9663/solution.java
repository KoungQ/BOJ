package BOJ.N_Queen_9663;

import java.util.Scanner;

public class solution {

    private static int[] prev;
    private static int cnt, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            prev = new int[n];
            dfs(0, i);
        }

        System.out.println(cnt);
    }

    static void dfs(int y, int x) {
        if(y == n - 1) {
            cnt++;
            return;
        }

        prev[y] = x;

        for(int j = 0; j < n; j++) {
            boolean isOK = true;
            for (int i = 0; i < y + 1; i++) {
                if(j == prev[i])
                    isOK = false;
                if(j == prev[i] - (y + 1 - i))
                    isOK = false;
                if(j == prev[i] + (y + 1 - i))
                    isOK = false;
            }

            if(isOK) {
                prev[y + 1] = j;
                dfs(y + 1, j);
            }

        }
    }
}
