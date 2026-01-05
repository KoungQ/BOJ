class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        char[] chArr = s.toCharArray();
        int length = chArr.length;
        
        if(length == 4 || length == 6) {
            for(int i = 0; i < length; i++) {
                if(!('0' <= chArr[i] && chArr[i] <= '9')) {
                    answer = false;
                    break;
                }
            }
        } else {
            answer = false;
        }
        
        return answer;
    }
}