package BOJ.쿼드트리_1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {

    static int n;
    static boolean[][] field;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        field = new boolean[n][n];

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            String line = br.readLine();

            for(int j = 0; j < n; j++) {
                field[i][j] = line.charAt(j) == '1';    // 칠해진 영역 = true, 칠해지지 않은 영역 = 0

                if(field[i][j])     // divide 검사 필요성 유무를 위해 cnt에 칠해진 영역 수 저장
                    cnt++;
            }
        }

        if(cnt == n * n)    // 모든 영역이 1이라면 -> divide 필요 X, 출력
            System.out.println(1);
        else if(cnt == 0)   // 모든 영역이 0이라면 위와 동일
            System.out.println(0);
        else {
            divide(0, 0, n);
            System.out.println(sb);
        }
    }

    static void divide(int y, int x, int size) {
        sb.append('(');

        if(!conquer(y, x, size / 2))  // 왼쪽 위
            divide(y, x, size / 2);

        if(!conquer(y, x + size / 2, size / 2))  // 오른쪽 위
            divide(y, x + size / 2, size / 2);

        if(!conquer(y + size / 2, x, size / 2))  // 왼쪽 아래
            divide(y + size / 2, x,size / 2);

        if(!conquer(y + size / 2, x + size / 2, size / 2))  // 오른쪽 아래
            divide(y + size / 2, x + size / 2,size / 2);

        sb.append(')');
    }

    static boolean conquer(int y, int x, int size) {
        int endY = y + size;
        int endX = x + size;

        int cnt = 0;
        for(int ny = y; ny < endY; ny++) {  // 해당 영역을 돌면서 칠해진 영역 수 구하기
            for(int nx = x; nx < endX; nx++) {
                if(field[ny][nx])
                    cnt++;
            }
        }

        // 결과
        if(cnt == 0) {  // 해당 영역이 칠해져 있지 않다면,
            sb.append(0);   // 출력
            return true;    // 정복 완료
        }

        if(cnt == size * size) { // 해당 영역이 칠해져 있다면,
            sb.append(1);   // 출력
            return true;    // 정복 완료
        }

        return false;   // 색이 섞여있는 영역이라면, 정복 실패
    }
}
