import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for(int i = 1; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                Integer top = stack.pop();
                answer[top] = i - top;
            }
            
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            Integer top = stack.pop();
            answer[top] = prices.length - top - 1;
        }
        
        
        return answer;
    }
}