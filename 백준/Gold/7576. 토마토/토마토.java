import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static int[][] visited;
    static int rows, cols;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<int[]> ripenTomato = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        cols = Integer.parseInt(st.nextToken());
        rows = Integer.parseInt(st.nextToken());

        graph = new int[rows][cols];
        visited = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cols; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    ripenTomato.offer(new int[]{i, j});
                }
            }
        }

        bfs();

        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, visited[i][j]);
            }
        }

        System.out.println(result);
    }

    public static void bfs() {
        while (!ripenTomato.isEmpty()) {
            int[] current = ripenTomato.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols) {
                    if (graph[nx][ny] == 0 && visited[nx][ny] == 0) {
                        graph[nx][ny] = 1;
                        visited[nx][ny] = visited[x][y] + 1;
                        ripenTomato.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
