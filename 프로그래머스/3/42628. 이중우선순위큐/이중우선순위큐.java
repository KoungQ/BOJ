import java.util.*;

class Solution {
    
    TreeMap<Integer, Integer> queue;
    
    public int[] solution(String[] operations) {
        int[] answer = {};
        queue = new TreeMap<>();
        
        for (String op : operations) {
            executeOperation(op);
        }
        
        if (queue.isEmpty()) {
            return new int[] {0, 0};
        }
        
        return new int[] {queue.lastKey(), queue.firstKey()};
    }
    
    public void executeOperation(String op) {
        String[] parts = op.split(" ");
        String command = parts[0];
        int num = Integer.parseInt(parts[1]);
        
        if (command.equals("I")) {
            queue.put(num, queue.getOrDefault(num, 0) + 1);
        } else if (command.equals("D")) {
            if (queue.isEmpty()) {
                return;
            }
            
            if (num == 1) {
                int max = queue.lastKey();
                if (queue.get(max) == 1) {
                    queue.remove(max);
                } else {
                    queue.put(max, queue.get(max) - 1);
                }
            } else {
                int min = queue.firstKey();
                if (queue.get(min) == 1) {
                    queue.remove(min);
                } else {
                    queue.put(min, queue.get(min) - 1);
                }
            }
        }
    }
}