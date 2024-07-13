package BOJ.연구소_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class solution {

    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};

    static int n, m, ny, nx, empty, cnt, max = 0;
    static int[][] area;
    static int[][] tmp;
    static LinkedList<Virus> virusList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        area = new int[n][m];
        tmp = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());    // 0 == 빈 칸, 1 == 벽, 2 == 바이러스

                if(area[i][j] == 0) {
                    empty++;
                    continue;
                }

                if(area[i][j] == 2)
                    virusList.add(new Virus(i, j));
            }
        }

        block(3);

        System.out.println(max);
    }

    static void block(int wallCnt) {
        if(wallCnt == 0) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    tmp[i][j] = area[i][j];
                }
            }

            for (Virus virus : virusList)
                count(virus.y, virus.x);    // 시간 초과가 난다면 불필요한 탐색 중지하는 방법도 생각하자

            if(max < empty - cnt) {
                max = empty - cnt;
            }

            cnt = 0;
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(area[i][j] == 0) {
                    area[i][j] = 3;
                    block(wallCnt - 1);
                    area[i][j] = 0;
                }
            }
        }
    }

    static void count(int y, int x) {
        cnt++;
        tmp[y][x] = 2;

        for(int i = 0; i < 4; i++) {
            ny = y + dy[i];
            nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m)
                continue;

            if(tmp[ny][nx] == 0) {
                count(ny, nx);
            }
        }
    }
}

class Virus {
    Integer y;
    Integer x;

    public Virus(Integer y, Integer x) {
        this.y = y;
        this.x = x;
    }
}