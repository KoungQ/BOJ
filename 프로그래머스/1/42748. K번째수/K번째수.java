import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int[] sliced = slice(array, commands[i][0] - 1, commands[i][1] - 1);
            Arrays.sort(sliced);
            answer[i] = sliced[commands[i][2] - 1];
        }
        
        return answer;
    }
    
    public int[] slice(int[] arr, int startIdx, int endIdx) {
        int[] result = new int[endIdx - startIdx + 1];
        
        for(int i = startIdx; i <= endIdx; i++) {
            result[i - startIdx] = arr[i];
        }
        
        return result;
    }
}