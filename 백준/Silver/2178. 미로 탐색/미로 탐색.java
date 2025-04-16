import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] maze;
    static int[][] visited;

    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};
    static int nx, ny, n, m = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 미로의 행 입력 받기
        m = Integer.parseInt(st.nextToken());   // 미로의 열 입력 받기

        maze = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++) {
            char[] token = new StringTokenizer(br.readLine()).nextToken().toCharArray();    // 미로 입력 받기
            for(int j = 0; j < m; j++) {
                maze[i][j] = token[j] - '0';
            }
        }

        bfs(0, 0);

        System.out.println(visited[n - 1][m - 1]);
    }

    static void bfs(int sx, int sy) {   // sx = StartX, sy = StartY
        Queue<Pair> queue = new LinkedList<>();
        visited[sx][sy] = 1;
        queue.add(new Pair(sx, sy));
        while(!queue.isEmpty()) {
            Pair here = queue.poll();

            for(int i = 0; i < 4; i++) {
                int ny = here.y + dy[i];
                int nx = here.x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m || maze[ny][nx] == 0)
                    continue;
                if(visited[ny][nx] > 0)
                    continue;
                visited[ny][nx] = visited[here.y][here.x] + 1;
                queue.add(new Pair(ny, nx));
            }
        }
    }
}

class Pair {
    Integer y;
    Integer x;

    public Pair(Integer y, Integer x) {
        this.y = y;
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getX() {
        return x;
    }
}
