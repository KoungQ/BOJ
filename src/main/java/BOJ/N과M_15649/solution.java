package BOJ.N과M_15649;

import java.util.Scanner;

public class solution {

    private static boolean[] visited;
    private static int[] output;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n];
        output = new int[n];

        permutation(0, n, m);
    }

    static void permutation(int depth, int n, int r) {
        if (depth == r) {
            print(output, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = i + 1;
                permutation(depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    static void print(int[] arr, int r) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < r; i++)
            sb.append(arr[i]).append(" ");
        System.out.println(sb);
    }
}
