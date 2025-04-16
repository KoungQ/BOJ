import java.util.Scanner;

public class Main {

    private static boolean[] visited;
    private static int[] output;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n];
        output = new int[n];
        // 1~n 개의 수 중 m 개를 순서 상관하여 뽑기 nPm

        perm(0, n, m);
    }

    static void perm(int depth, int n, int r) {
        if (depth == r) {
            print(output, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = i + 1;
                perm(depth + 1, n, r);
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
