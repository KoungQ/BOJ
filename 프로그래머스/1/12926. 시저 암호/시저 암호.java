class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char[] charArr = s.toCharArray();
        for(int i = 0; i < charArr.length; i++) {
            if(charArr[i] >= 'A' && charArr[i] <= 'Z')
                charArr[i] = (char) ((charArr[i] - 'A' + n) % 26 + 'A') ;
            
            if(charArr[i] >= 'a' && charArr[i] <= 'z')
                charArr[i] = (char) ((charArr[i] - 'a' + n) % 26 + 'a') ;
        }
        
        answer = String.valueOf(charArr);
        
        return answer;
    }
}