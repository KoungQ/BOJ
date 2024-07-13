package BOJ.로봇청소기_14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {

    static int[] dx = {0, 1, 0, -1};     // 북, 동, 남, 서
    static int[] dy = {-1, 0, 1, 0};

    static int n, m, r, c, d, ny, nx, cnt = 0;
    static int[][] area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        area = new int[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());


        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());    // 0 = 청소해야 하는 곳 (true), 1 = 벽 (false)
            }
        }

        move(r, c, d);

        System.out.println(cnt);
    }

    static void move(int y, int x, int dir) {
        if(area[y][x] == 0) // 현재 위치가 청소가 안됐을 경우, +1
            cnt++;

        area[y][x] = -1;    // -1 = 청소한 곳

        if(area[y + dy[0]][x + dx[0]] != 0 &&       // 네 방향 중 청소할 구역이 없다면
                area[y + dy[1]][x + dx[1]] != 0 &&
                area[y + dy[2]][x + dx[2]] != 0 &&
                area[y + dy[3]][x + dx[3]] != 0) {

            if (area[y - dy[dir]][x - dx[dir]] == 1)     // 후진하려는 곳이 벽이라면
                return;     // 청소 종료
            move(y - dy[dir], x - dx[dir], dir);  // 후진
        } else {    // 청소할 구역이 있다면

            for(int i = 0; i < 4; i++) {
                int currentDir = (dir + (4 - i) + 3) % 4;   // 반시계 방향으로 돌기

                ny = y + dy[currentDir];
                nx = x + dx[currentDir];

                if(area[ny][nx] == 0) {
                    move(ny, nx, currentDir);
                    return;     // 올바른 방향으로 나아갔을 경우 재귀 호출이 끝난 후 다른 방향도 탐색하지 않도록 return
                }
            }
        }
    }
}
