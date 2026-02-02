import java.util.*;

class Solution {
    
    Map<String, Integer> countMap = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        
        char[][] orderArr = new char[orders.length][];
        for(int i = 0; i < orders.length; i++) {
            orderArr[i] = orders[i].toCharArray();
            Arrays.sort(orderArr[i]);
        }
        
        for(int c : course) {
            countMap.clear();
            
            for (int i = 0; i < orderArr.length; i++) {
                if (orderArr[i].length >= c) {
                    dfs(orderArr[i], 0, c, new StringBuilder());
                }
            }
            
            int max = 0;
            for (int v : countMap.values()) {
                if (v >= 2) max = Math.max(max, v);
            }
            
            if (max >= 2) {
                for (Map.Entry<String, Integer> e : countMap.entrySet()) {
                    if (e.getValue() == max) {
                        result.add(e.getKey());
                    }
                }
            }
        }
        
        Collections.sort(result);
        
        return result.toArray(new String[0]);
    }
    
    public void dfs(char[] order, int start, int targetLen, StringBuilder pick) {
        if (pick.length() == targetLen) {
            String key = pick.toString();
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
            return;
        }

        for (int i = start; i < order.length; i++) {
            pick.append(order[i]);
            dfs(order, i + 1, targetLen, pick);
            pick.deleteCharAt(pick.length() - 1);
        }
    }
}