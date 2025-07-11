import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M, cnt;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        map = new char[N][M];
        visited = new boolean[N][M];

        int sy = 0, sx = 0;               // I(도연) 시작 위치
        for (int i = 0; i < N; i++) {
            String line = br.readLine();  // 한 줄 통째로 읽기
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'I') {
                    sy = i;
                    sx = j;
                }
            }
        }

        dfs(sy, sx);
        System.out.println(cnt == 0 ? "TT" : cnt);
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;
        if (map[y][x] == 'P') cnt++;
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d], nx = x + dx[d];
            if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
            if (visited[ny][nx] || map[ny][nx] == 'X') continue;
            dfs(ny, nx);
        }
    }
}
