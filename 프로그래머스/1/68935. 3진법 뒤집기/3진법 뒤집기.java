class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String base3Str = Integer.toString(n, 3);
        String base3ReverseStr = new StringBuilder(base3Str).reverse().toString();
        answer = Integer.parseInt(base3ReverseStr, 3);
        
        return answer;
    }
}