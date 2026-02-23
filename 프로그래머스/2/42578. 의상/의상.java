import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            String name = clothes[i][0];

            int value = map.getOrDefault(type, 0);
            map.put(type, value + 1);
        }
        
        int answer = 1;
        for (Integer value : map.values()) {
            answer *= (value + 1);
        }
        
        return answer - 1;
    }
}