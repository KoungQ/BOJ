import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int chunkSize = 1; chunkSize < s.length(); chunkSize++) {
            
            List<String> chunks = new ArrayList();
            int strlen = s.length();
            for(int i = 0; i < strlen; i += chunkSize) {
                if(i + chunkSize < strlen)
                    chunks.add(s.substring(i, i + chunkSize));
                else
                    chunks.add(s.substring(i, strlen));
            }

            String result = "";
            int dupCount = 1;
            for(int i = 0; i < chunks.size() - 1; i++) {
                if(chunks.get(i).equals(chunks.get(i + 1))) {
                    dupCount++;
                    
                    if(i == chunks.size() - 2) {
                        result += dupCount;
                        result += chunks.get(i);
                    }
                } else {
                    if(dupCount != 1) {
                        result += dupCount;
                    }
                    result += chunks.get(i);
                    dupCount = 1;
                    
                    if(i == chunks.size() - 2) {
                        result += chunks.get(i + 1);
                    }
                }
            }
            
            if(answer > result.length())
                answer = result.length();
        }
        
        return answer;
    }
}