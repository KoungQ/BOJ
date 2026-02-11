class Solution {
    public int solution(int[][] dots) {
        if(isParallel(dots[0], dots[1], dots[2], dots[3]))
            return 1;
        
        if(isParallel(dots[0], dots[2], dots[1], dots[3]))
            return 1;
        
        if(isParallel(dots[0], dots[3], dots[1], dots[2]))
            return 1;
        
        return 0;
    }
    
    public boolean isParallel(int[] a1, int[] a2, int[] b1, int[] b2) {
        if(slope(a1, a2) == slope(b1, b2))
            return true;
        return false;   
    }
    
    public double slope(int[] p1, int[] p2) {
        return (double) (p1[1] - p2[1]) / (p1[0] - p2[0]);
    }
}