import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 행렬 크기 입력 받기

        int[] result = new int[n];
        int[][] matrix = new int[n][n];     // 행렬 입력 받기
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int orResult = 0;
            for(int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                orResult |= matrix[i][j];
            }

            // 한 라인 전부 입력받음 그럼 이 연산들의 or 하면 될까..?
            result[i] = orResult;
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
