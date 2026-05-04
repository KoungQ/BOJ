import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> queue = new LinkedList<>();
        
        // 찾으면 끝, 처리할 프로세스 아니면 다시 offer
        
        for(int i = 0; i < priorities.length; i++) {
            queue.offer(priorities[i]);
            priority.offer(priorities[i]);
        }
        
        while (true) {
            int qPoll = queue.poll();
            int pPeek = priority.peek();

            if (qPoll != pPeek) {
                queue.offer(qPoll);

                if (location == 0) {
                    location = queue.size() - 1;
                } else {
                    location--;
                }
            } else {
                priority.poll();
                answer++;

                if (location == 0) {
                    return answer;
                } else {
                    location--;
                }
            }
        }
    }
}