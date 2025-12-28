import java.io.*;
import java.util.*;

public class Main {
    static void flip(char[][] a, int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                a[i][j] = (a[i][j] == '0') ? '1' : '0';
            }
        }
    }

    static boolean same(char[][] a, char[][] b) {
        int n = a.length;
        int m = a[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] a = new char[n][m];
        char[][] b = new char[n][m];

        for (int i = 0; i < n; i++) a[i] = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) b[i] = br.readLine().toCharArray();

        if (n < 3 || m < 3) {
            System.out.print(same(a, b) ? 0 : -1);
            return;
        }

        int cnt = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (a[i][j] != b[i][j]) {
                    flip(a, i, j);
                    cnt++;
                }
            }
        }

        System.out.print(same(a, b) ? cnt : -1);
    }
}
