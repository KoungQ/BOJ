import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i));
        }
        
        for(int i = 0; i < queue.size(); i++) {
            if(calculate(queue))
                answer++;
            
            Character c = queue.poll();
            queue.offer(c);
        }
        
        return answer;
    }
    
    boolean calculate(Queue<Character> queue) {
        Stack<Character> stack = new Stack<>();

        for (Character c : queue) {
            // 여는 괄호
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // 닫는 괄호
            else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}