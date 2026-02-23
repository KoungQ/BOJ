import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> pocketmon = new HashMap<>();
        
        for(int num : nums) {
            int value = pocketmon.getOrDefault(num, 0);
            pocketmon.putIfAbsent(num, value + 1);
        }
        
        int size = pocketmon.size();
        if(size > nums.length / 2)
            return nums.length / 2;
        return size;
    }
}