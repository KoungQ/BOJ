import java.util.*;

class Solution {
    
    Set<Character> set = new HashSet<>();
    
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = my_string.toCharArray();
        
        for(char c : charArr) {
            if(set.contains(c))
                continue;
            set.add(c);
            sb.append(c);
        }
        
        return sb.toString();
    }
}