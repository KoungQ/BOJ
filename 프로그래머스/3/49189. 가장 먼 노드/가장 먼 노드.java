import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 그래프 초기화
        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(edge[i][1]);  // 양방향
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        // bfs 초기화
        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        // 출발점 초기화
        distance[1] = 0;
        queue.offer(1);
        visited[1] = true;
        int max = 0;
        
        // bfs
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            for(int next : graph[current]) {
                if(!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                    
                    if(max < distance[next])
                        max = distance[next];
                    
                    queue.offer(next);
                }
            }
        }
        
        // 가장 먼 노드 개수 구하기
        for(int i = 0; i < distance.length; i++) {
            if(max == distance[i])
                answer++;
        }
        
        return answer;
    }
}