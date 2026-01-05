class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        
        int pCount = countChar(s, "p");
        int yCount = countChar(s, "y");
        
        answer = pCount == yCount;
        
        return answer;
    }
    
    int countChar(String before, String ch) {
        String after = before.replace(ch, "");
        return before.length() - after.length();
    }
}

