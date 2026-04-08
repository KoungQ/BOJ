class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    void dfs(int here, int[][] computers) {
        visited[here] = true;
        
        int[] network = computers[here];
        for(int i = 0; i < computers.length; i++) {
            if(i == here)
                continue;
            
            if(network[i] == 1 && !visited[i])
                dfs(i, computers);
        }
    }
}