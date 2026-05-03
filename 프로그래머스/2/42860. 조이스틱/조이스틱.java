class Solution {
    public int solution(String name) {
        // 1. 알파벳 변경 횟수
        int answer = 0;

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        // 2. 커서 이동 최소 횟수
        int len = name.length();
        int move = len - 1;

        for (int i = 0; i < len; i++) {
            int next = i + 1;

            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            move = Math.min(move, i * 2 + len - next);
            move = Math.min(move, (len - next) * 2 + i);
        }

        // 3. 최종 답
        answer += move;
        
        return answer;
    }
}