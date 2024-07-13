package BOJ.유기농_배추_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution_v2 {

    static int t, m, n, ny, nx, k, ret;
    static int[] dy = new int[]{-1, 0, 0, 1};
    static int[] dx = new int[]{0, -1, 1, 0};
    static boolean[][] field;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());   // 테스트 케이스 수

        for(int a = 0; a < t; a++) {
            int cnt = 0;
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());   // 배추 밭 가로 길이
            n = Integer.parseInt(st.nextToken());   // 배추 밭 세로 길이
            k = Integer.parseInt(st.nextToken());   // 배추 개수

            field = new boolean[n][m];
            visited = new boolean[n][m];

            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                field[y][x] = true;
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {    // 위치를 리스트에 하나씩 저장해서 삽입, 조회보다 직접 끝까지 도는게 코드가 간결함
                    if(field[i][j] && !visited[i][j]) {
                        dfs(i, j);
                        ret++;
                    }
                }
            }

            System.out.println(ret);
        }
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            ny = y + dy[i];
            nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m)
                continue;

            if(field[ny][nx] && !visited[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }
}
