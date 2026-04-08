import java.util.*;

class Solution {
    
    int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public int solution(int[] arrows) {
        int answer = 0;
        
        Set<String> visitedNode = new HashSet<>();
        Set<String> visitedEdge = new HashSet<>();
        
        int y = 0;
        int x = 0;
        
        visitedNode.add(y + "," + x);
        
        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) {
                int ny = y + dy[arrow];
                int nx = x + dx[arrow];
                
                String currentNode = y + "," + x;
                String nextNode = ny + "," + nx;
                
                String edge = currentNode + ":" + nextNode;
                String reverseEdge = nextNode + ":" + currentNode;
                
                if (visitedNode.contains(nextNode) && !visitedEdge.contains(edge)) {
                    answer++;
                }
                
                visitedNode.add(nextNode);
                visitedEdge.add(edge);
                visitedEdge.add(reverseEdge);
                
                y = ny;
                x = nx;
            }
        }
        
        return answer;
    }
}