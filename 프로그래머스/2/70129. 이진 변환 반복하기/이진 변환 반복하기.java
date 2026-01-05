class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        

        int deletedZeroCount = 0;
        int loopCount = 0;
        for(; !s.equals("1"); loopCount++) {
            // 비교를 위한 제거 이전 값 임시 복사
            String tmp = s;
            
            // step 1. 모든 0 제거
            s = s.replace("0", "");
            
            // 지워진 0의 개수 count
            deletedZeroCount += tmp.length() - s.length();
        
            // step 2. 문자열 길이를 2진법으로 표현
            s = Integer.toString(s.length(), 2);
        }
        
        answer = new int[2];
        answer[0] = loopCount;
        answer[1] = deletedZeroCount;
        
        return answer;
    }
}