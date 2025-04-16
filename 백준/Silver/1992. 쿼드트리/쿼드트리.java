import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

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

                if(field[i][j])
                    cnt++;
            }
        }

        if(cnt == n * n)
            System.out.println(1);
        else if(cnt == 0)
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
        for(int ny = y; ny < endY; ny++) {
            for(int nx = x; nx < endX; nx++) {
                if(field[ny][nx])
                    cnt++;
            }
        }

        if(cnt == 0) {
            sb.append(0);
            return true;
        } else if(cnt == size * size) {
            sb.append(1);
            return true;
        }
        return false;
    }
}
