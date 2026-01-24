class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] jumpSize = {781, 156, 31, 6, 1};
        
        char[] arr = word.toCharArray();
        
        for(int i = 0; i < arr.length; i++) {
            answer += value(arr[i]) * jumpSize[i] + 1;
        }
        
        return answer;
    }
    
    public int value(char c) {
        if(c == 'A')
            return 0;
        else if(c == 'E')
            return 1;
        else if(c == 'I')
            return 2;
        else if(c == 'O')
            return 3;
        else    // U
            return 4;
        
    }
}