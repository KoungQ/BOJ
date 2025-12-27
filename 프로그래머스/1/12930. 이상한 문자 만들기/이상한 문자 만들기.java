class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int cursor = 1;
        for(char c : charArr) {
            if(c == ' ') {
                cursor = 1;
                sb.append(' ');
                continue;
            }
            
            if(cursor % 2 == 0)
                sb.append(Character.toLowerCase(c));
            else
                sb.append(Character.toUpperCase(c));
            
            cursor++;
        }
        
        answer = sb.toString();
        return answer;
    }
}