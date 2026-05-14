import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville)
            pq.offer(i);
        
        while(!pq.isEmpty() && pq.peek() < K) {
            if(pq.size() < 2)
                return -1;
            
            int s1 = pq.poll();
            int s2 = pq.poll();

            pq.offer(s1 + s2 * 2);
            answer++;
        }
        
        return answer;
    }
}