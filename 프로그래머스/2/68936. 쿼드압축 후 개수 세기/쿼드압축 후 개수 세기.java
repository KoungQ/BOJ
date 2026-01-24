class Solution {
    int[] result = new int[2];
    
    public int[] solution(int[][] arr) {        
        solve(arr, 0, 0, arr.length);
        return result;
    }
    
    public void solve(int[][] arr, int row, int col, int size) {
        if(size == 1) {
            result[arr[row][col]]++;
            return;
        }
        
        if(isSame(arr, row, col, size)) {
            result[arr[row][col]]++;
            return;
        }
        
        int half = size / 2;
        
        solve(arr, row, col, half);
        solve(arr, row + half, col, half);
        solve(arr, row, col + half, half);
        solve(arr, row + half, col + half, half);
    }
    
    public boolean isSame(int[][] arr, int row, int col, int size) {
        int base = arr[row][col];
        boolean isSame = true;
        
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != base) 
                    return false;
            }
        }
        
        return isSame;
    }
}