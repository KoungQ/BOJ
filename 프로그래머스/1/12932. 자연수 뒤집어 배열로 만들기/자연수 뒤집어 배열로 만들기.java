class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        
        // 뒤집기 연산
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        sb.reverse();
        char[] charArr = sb.toString().toCharArray();
        
        // 문자열 초기화 및 삽입
        answer = new int[charArr.length];
        for(int i = 0; i < charArr.length; i++) {
            answer[i] = charArr[i] - '0';
        }
        
        return answer;
    }
}