package BOJ.단지번호붙이기_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class solution {

    static boolean[][] map;
    static boolean[][] visited;

    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};
    static int nx, ny, n, cnt = 0;
    static ArrayList<Integer> houses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 지도의 크기 입력 받기

        map = new boolean[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) == '1';
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] && !visited[i][j]){
                    dfs(i, j);
                    houses.add(cnt);
                    cnt = 0;
                }
            }
        }

        System.out.println(houses.size());

        Collections.sort(houses);
//        houses.sort(Comparator.naturalOrder()); // 오름차순 정렬
        for (Integer house : houses) {
            System.out.println(house);
        }
    }

    static void dfs(int y, int x) {
        cnt++;
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            ny = y + dy[i];
            nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if(map[ny][nx] && !visited[ny][nx]){
                dfs(ny, nx);
            }
        }
    }
}
