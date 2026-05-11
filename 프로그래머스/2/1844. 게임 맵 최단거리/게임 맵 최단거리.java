import java.util.*;

class Solution {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};
    int[][] visited;
    int m, n;
    
    public int solution(int[][] maps) {
        m = maps.length;
        n = maps[0].length;
        visited = new int[m][n];
        
        bfs(0, 0, maps);
        
        if(visited[m - 1][n - 1] == 0)
            return -1;
        return visited[m - 1][n - 1];
    }
    
    void bfs(int startX, int startY, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        
        // init start
        queue.offer(new int[]{startY, startX});
        visited[startY][startX] = 1;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int dist = visited[current[0]][current[1]];
            
            for(int i = 0; i < 4; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];
                
                if(ny > m - 1 || ny < 0 || nx > n - 1 || nx < 0)  // 맵 밖에 나갔을 때
                    continue;
                
                if(maps[ny][nx] == 1 && visited[ny][nx] == 0) {
                    queue.offer(new int[]{ny, nx});
                    visited[ny][nx] = dist + 1;
                }
            }
        }
        
    }
}