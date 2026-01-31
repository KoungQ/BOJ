import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        Arrays.sort(
            strings,
            (a, b) -> {
                char[] aArr = a.toCharArray();
                char[] bArr = b.toCharArray();
                
                if(aArr[n] != bArr[n])
                    return aArr[n] - bArr[n];
                else
                    return a.compareTo(b);
            }
        );
        
        return strings;
    }
}