import java.util.*;

class Solution {
    boolean[] visited;
    int answer = 0;
    int min = 9999;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        findMin(dungeons);
        dfs(dungeons, k, 0);
        return answer;
    }
    
    void dfs(int[][] dungeons, int k, int count) {
        answer = Math.max(answer, count);
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(dungeons, k - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
    
    void findMin(int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {
            if (min > dungeons[i][0])
                min = dungeons[i][0];
        }
    }
}

