import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] answers) {
        int[][] p = {{1, 2, 3, 4, 5}, 
                     {2, 1, 2, 3, 2, 4, 2, 5}, 
                     {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        
        int max = 0;
        int[] corrects = new int[3];
        for(int i = 0; i < answers.length; i++) {
            for(int j = 0; j < corrects.length; j++) {
                if(answers[i] == p[j][i % p[j].length]) {  
                    corrects[j]++;
                    if(max < corrects[j])
                        max = corrects[j];
                }
            }
        }
        
        final int maxCorrect = max;
        return IntStream.range(0, 3)
            .filter(i -> corrects[i] == maxCorrect)
            .map(i -> i + 1)
            .toArray();
    }
}