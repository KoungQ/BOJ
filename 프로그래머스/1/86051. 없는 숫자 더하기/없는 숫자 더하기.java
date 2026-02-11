import java.util.*;

class Solution {
    
    boolean[] isUsed = new boolean[10];
    
    public int solution(int[] numbers) {
        int answer = 0;
        
        for(int n : numbers) {
            isUsed[n] = true;
        }
        
        for(int i = 0; i < 10; i++) {
            if(!isUsed[i])
                answer += i;
        }
        
        return answer;
    }
}