class Solution {
    boolean visited[];
    int answer;
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        
        // target이 words에 포함되지 않을 때 == 불가능
        if(!contains(words, target))
            return 0;
        
        int wCnt = words.length;
        visited = new boolean[wCnt];
        
        // begin에서 이동할 수 있는 모든 지점에서 dfs 시작
        for(int i = 0; i < wCnt; i++) {
            if(isConvertible(begin, words[i]))
                dfs(begin, words, target, 0);
        }
        
        return answer;
    }
    
    void dfs(String now, String words[], String target, int count) {
        // target 탐색 여부 검사
        if(now.equals(target)) {
            if(answer > count)
                answer = count;
            return;
        }

        
        for(int i = 0; i < words.length; i++) {
            if(now.equals(words[i]))
                visited[i] = true;
        }
        
        // 이동할 수 있는 지점 탐색
        for(int i = 0; i < words.length; i++) {
            if(isConvertible(now, words[i]) && !visited[i]) {
                dfs(words[i], words, target, count + 1);
            }
        }
    }
    
    boolean isConvertible(String from, String to) {
        int n = from.length();
        int matchCnt = 0;
        
        for(int i = 0; i < n; i++) {
            if(from.charAt(i) == to.charAt(i))
                matchCnt++;
        }

        return n - matchCnt == 1;
    }
    
    boolean contains(String[] words, String target) {
        boolean flag = false;
        
        for(String word : words) {
            if(word.equals(target))
                flag = true;
        }
        
        return flag;
    }    
}