package BOJ.체스판_다시_칠하기_1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {

    private static int n, m;
    private static boolean[][] board;
    private static boolean[][] version1 = {
            {true, false, true, false, true, false, true, false},   // 흰 블럭 시작
            {false, true, false, true, false, true, false, true},
            {true, false, true, false, true, false, true, false},
            {false, true, false, true, false, true, false, true},
            {true, false, true, false, true, false, true, false},
            {false, true, false, true, false, true, false, true},
            {true, false, true, false, true, false, true, false},
            {false, true, false, true, false, true, false, true},
    };
    private static boolean[][] version2 = {
            {false, true, false, true, false, true, false, true},   // 검은 블럭 시작
            {true, false, true, false, true, false, true, false},
            {false, true, false, true, false, true, false, true},
            {true, false, true, false, true, false, true, false},
            {false, true, false, true, false, true, false, true},
            {true, false, true, false, true, false, true, false},
            {false, true, false, true, false, true, false, true},
            {true, false, true, false, true, false, true, false},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 체스판 높이 입력 받기
        m = Integer.parseInt(st.nextToken());   // 체스판 너비 입력 받기

        board = new boolean[n][m];  // B = false, W = true

        // 너비나 높이 중 하나라도 0이라면 입력 받는 값 없이 바로 0 출력 후 리턴
        if(n == 0 || m == 0) {
            System.out.println(0);
            return;
        }

        // 입력 받기
        for(int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) == 'W';
            }
        }

        int min = 9999; // 임시 값
        for(int i = 0; i + 8 <= n; i++) {
            for(int j = 0; j + 8 <= m; j++) {

                int cnt = 0;
                for(int k = i; k < 8 + i; k++) {        // version1 과 비교
                    for(int l = j; l < 8 + j; l++) {
                        if(board[k][l] != version1[k - i][l - j])
                            cnt++;
                    }
                }

                if(min > cnt) {
                    min = cnt;
                }

                cnt = 0;
                for(int k = i; k < 8 + i; k++) {        // version2 와 비교
                    for(int l = j; l < 8 + j; l++) {
                        if(board[k][l] != version2[k - i][l - j])
                            cnt++;
                    }
                }

                if(min > cnt) {
                    min = cnt;
                }
            }
        }

        System.out.println(min);
    }
}
