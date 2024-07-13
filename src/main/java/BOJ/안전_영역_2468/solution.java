package BOJ.안전_영역_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {

    static int n, ny, nx, ret, height, max = 0;

    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    static int[][] field;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        field = new int[n][n];
        for(int i = 0; i < n; i++) {    // 입력 받기
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                field[i][j] = Integer.parseInt(st.nextToken()); // 잠긴 부분 == false, 잠기지 않은 부분 = true
            }
        }

        for(height = 0; height <= 100; height++) {
            ret = 0;
            visited = new boolean[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(field[i][j] > height && !visited[i][j]) {
                        ret++;
                        dfs(i, j, height);
                    }
                }
            }

            if(max < ret)
                max = ret;
        }

        System.out.println(max);
    }

    static void dfs(int y, int x, int height) {
        visited[y][x] = true;
        for(int i = 0; i < 4; i++) {
            ny = y + dy[i];
            nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n)
                continue;

            if(field[ny][nx] > height && !visited[ny][nx])
                dfs(ny, nx, height);
        }
    }
}
