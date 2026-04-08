class Solution {
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, -1, 0, 1};
    boolean[][] visited;
    boolean answer;

    public boolean exist(char[][] board, String word) {
        char[] wordArr = word.toCharArray();
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(wordArr[0] == board[i][j]) {
                    visited = new boolean[board.length][board[0].length];
                    dfs(i, j, board, wordArr, 1);

                    if(answer)
                        return true;
                }
            }
        }
        
        return false;
    }

    void dfs(int y, int x, char[][] board, char[] word, int cursor) {
        if(cursor == word.length) {
            answer = true;
            return;
        }

        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= board.length || ny < 0 
            || nx >= board[0].length || nx < 0) {
                continue;
            }

            if(!visited[ny][nx] && board[ny][nx] == word[cursor])
                dfs(ny, nx, board, word, cursor + 1);
        }

        visited[y][x] = false;
    }
}