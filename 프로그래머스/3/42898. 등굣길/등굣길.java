class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n + 2][m + 2];
        
        for(int[] puddle : puddles) {   // 물 웅덩이 표시
            int x = puddle[0];
            int y = puddle[1];
            
            map[y][x] = -1;
        }
        
        map[1][1] = 1; 
        for(int y = 1; y <= n; y++) {
            for(int x = 1; x <= m; x++) {
                if(map[y][x] == -1)
                    continue;
                
                if(map[y - 1][x] != -1)
                    map[y][x] += map[y - 1][x];
                if(map[y][x - 1] != -1)
                    map[y][x] += map[y][x - 1];
                
                map[y][x] %= 1_000_000_007;
            }
        }
        
        return map[n][m];
    }
}