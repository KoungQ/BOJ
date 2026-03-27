class Solution {
    int[][] num;
    int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        num = new int[numbers.length][2];
        
        for(int i = 0; i < numbers.length; i++) {
            num[i][0] = numbers[i];
            num[i][1] = numbers[i] * -1;
        }
        
        dfs(target, 0, 0);
        
        return answer;
    }
    
    void dfs(int target, int here, int sum) {
        if(here == num.length) {
            if(sum == target)
                answer++;
            return;
        }
        
        dfs(target, here + 1, sum + num[here][0]);  // 양수
        dfs(target, here + 1, sum + num[here][1]);  // 음수
    }
}