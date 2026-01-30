class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        for(int height = 1; height <= yellow / height; height++) {
            if(yellow % height != 0)
                continue;
            
            int width = yellow / height;
            if(brown == height * 2 + width * 2 + 4) {
                answer = new int[]{width + 2, height + 2};
                break;
            }
        }
        
        return answer;
    }
}