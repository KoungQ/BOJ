class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] cArr = s.toCharArray();
        
        if(cArr[0] == ')' || cArr[cArr.length - 1] == '(')
            return false;
        
        int leftCnt = 0;
        int rightCnt = 0;
        
        for(char c : cArr) {
            if(c == '(')
                leftCnt++;
            else {
                rightCnt++;
                if(rightCnt > leftCnt)
                    return false;
            }
        }
        
        if(leftCnt != rightCnt)
            return false;

        return answer;
    }
}