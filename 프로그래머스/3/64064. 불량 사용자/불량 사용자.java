import java.util.*;

class Solution {
    
    List<String> made = new ArrayList<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        for(String b : banned_id) {
            int count = 0;
            for(String u : user_id) {
                if(matches(b, u))
                    count++;
            }
            
            
            if(answer == 0)
                answer += count;
            else
                answer *= count;
        }
        
        return answer;
    }
    
    public boolean matches(String banned, String user) {
        char[] bannedArr = banned.toCharArray();
        char[] userArr = user.toCharArray();
        
        if(bannedArr.length != userArr.length)
            return false;
        
        for(int i = 0; i < bannedArr.length; i++) {
            if(bannedArr[i] == '*')
                continue;
            else
                if(bannedArr[i] != userArr[i])
                    return false;
        }
        
        return true;
    }
}