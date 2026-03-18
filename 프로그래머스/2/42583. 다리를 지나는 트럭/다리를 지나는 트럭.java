import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        int sum = 0;
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        int idx = 0;
        
        while (idx < truck_weights.length) {
            answer++;
            sum -= bridge.poll();
            
            if (sum + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
            } else {
                bridge.offer(0);
            }
        }
        
        answer += bridge_length;
        
        return answer;
    }
}