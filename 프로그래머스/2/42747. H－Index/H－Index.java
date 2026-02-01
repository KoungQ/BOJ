import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int h = citations[citations.length - 1]; h >= 0; h--) {
            int count = 0;
            
            for(int i = citations.length - 1; i >= 0; i--) {
                if(citations[i] >= h)
                    count++;
            }
            
            if(h <= count) {
                answer = h;
                break;
            }
            
        }
        
        return answer;
    }
}