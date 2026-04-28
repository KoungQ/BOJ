import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int max0 = 0;
        int max1 = 0;
            
        for(int i = 0; i < sizes.length; i++) {
            // 정렬
            Arrays.sort(sizes[i]);
            // [0]에서 가장 큰 값
            if(sizes[i][0] > max0)
                max0 = sizes[i][0];
            // [1]에서 가장 큰 값
            if(sizes[i][1] > max1)
                max1 = sizes[i][1];
        }
        
        return max0 * max1;
    }
}