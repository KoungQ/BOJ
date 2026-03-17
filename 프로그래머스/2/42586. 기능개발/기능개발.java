import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> dayQueue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = (remain + speeds[i] - 1) / speeds[i];
            dayQueue.offer(day);
        }

        List<Integer> answer = new ArrayList<>();

        while (!dayQueue.isEmpty()) {
            int first = dayQueue.poll();
            int count = 1;

            while (!dayQueue.isEmpty() && dayQueue.peek() <= first) {
                dayQueue.poll();
                count++;
            }

            answer.add(count);
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}