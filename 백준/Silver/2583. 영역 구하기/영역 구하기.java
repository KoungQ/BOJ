import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, k, ny, nx, ret = 0;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static boolean[][] visited;
    static boolean[][] field;
    static List<Integer> areaList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());   // 높이
        n = Integer.parseInt(st.nextToken());   // 너비
        k = Integer.parseInt(st.nextToken());   // 직사각형 개수

        field = new boolean[m][n];
        visited = new boolean[m][n];

        for(int i = 0; i < k; i++) {    // 직사각형 개수 만큼 iterate
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());  // 직사각형 왼쪽 아래 x좌표
            int y1 = Integer.parseInt(st.nextToken());  // 직사각형 왼쪽 아래 y좌표

            int x2 = Integer.parseInt(st.nextToken());  // 직사각형 오른쪽 위 x좌표
            int y2 = Integer.parseInt(st.nextToken());  // 직사각형 오른쪽 아래 y좌표

            for(int tmpY = m - y2; tmpY < m - y1; tmpY++) {    // 직사각형 칠하기
                for(int tmpX = x1; tmpX < x2; tmpX++) {
                    field[tmpY][tmpX] = true;   // true == 직사각형 범위, false == 직사각형 밖 범위
                }
            }
        }

        for(int y = 0; y < m; y++) {
            for(int x = 0; x < n; x++) {
                if(!visited[y][x] && !field[y][x]) {
                    dfs(y, x);
                    areaList.add(ret);
                    ret = 0;
                }
            }
        }

        Collections.sort(areaList);
        System.out.println(areaList.size());
        for (Integer area : areaList) {
            System.out.print(area + " ");
        }
    }

    static void dfs(int y, int x) {
        ret++;
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            ny = y + dy[i];
            nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= m || nx >= n)
                continue;

            if(!visited[ny][nx] && !field[ny][nx])
                dfs(ny, nx);
        }
    }
}
