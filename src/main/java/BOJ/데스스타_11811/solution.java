package BOJ.데스스타_11811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 행렬 크기 입력 받기

        int[] result = new int[n];
        int[][] matrix = new int[n][n];     // 행렬 입력 받기
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                result[i] |= matrix[i][j];  // 한 행의 값들 전부 or 연산
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
