import java.util.*;

class Solution {
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};
    List<List<int[]>> shapesGameboard;
    List<List<int[]>> shapesTable;
    boolean[][] visitedGameboard;
    boolean[][] visitedTable;
    int n;

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        shapesGameboard = new ArrayList<>();
        shapesTable = new ArrayList<>();

        n = game_board.length;
        visitedGameboard = new boolean[n][n];
        visitedTable = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game_board[i][j] == 0 && !visitedGameboard[i][j]) {
                    List<int[]> shapeGameboard = new ArrayList<>();
                    dfsGameboard(i, j, shapeGameboard, game_board);
                    shapesGameboard.add(normalize(shapeGameboard));
                }

                if (table[i][j] == 1 && !visitedTable[i][j]) {
                    List<int[]> shapeTable = new ArrayList<>();
                    dfsTable(i, j, shapeTable, table);
                    shapesTable.add(normalize(shapeTable));
                }
            }
        }

        boolean[] used = new boolean[shapesTable.size()];

        for (List<int[]> blank : shapesGameboard) {
            for (int i = 0; i < shapesTable.size(); i++) {
                if (used[i]) continue;

                List<int[]> block = shapesTable.get(i);

                if (blank.size() != block.size()) continue;

                boolean matched = false;
                List<int[]> rotated = copyShape(block);

                for (int r = 0; r < 4; r++) {
                    if (isSame(blank, rotated)) {
                        matched = true;
                        break;
                    }
                    rotated = rotate(rotated);
                }

                if (matched) {
                    used[i] = true;
                    answer += blank.size();
                    break;
                }
            }
        }

        return answer;
    }

    void dfsGameboard(int y, int x, List<int[]> shape, int[][] board) {
        visitedGameboard[y][x] = true;
        shape.add(new int[]{y, x});

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (visitedGameboard[ny][nx] || board[ny][nx] == 1) continue;

            dfsGameboard(ny, nx, shape, board);
        }
    }

    void dfsTable(int y, int x, List<int[]> shape, int[][] table) {
        visitedTable[y][x] = true;
        shape.add(new int[]{y, x});

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (visitedTable[ny][nx] || table[ny][nx] == 0) continue;

            dfsTable(ny, nx, shape, table);
        }
    }

    List<int[]> normalize(List<int[]> shape) {
        List<int[]> normalized = copyShape(shape);

        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;

        for (int[] p : normalized) {
            minY = Math.min(minY, p[0]);
            minX = Math.min(minX, p[1]);
        }

        for (int[] p : normalized) {
            p[0] -= minY;
            p[1] -= minX;
        }

        normalized.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        return normalized;
    }

    List<int[]> rotate(List<int[]> shape) {
        int maxY = 0;
        for (int[] p : shape) {
            maxY = Math.max(maxY, p[0]);
        }

        List<int[]> rotated = new ArrayList<>();
        for (int[] p : shape) {
            int y = p[0];
            int x = p[1];
            rotated.add(new int[]{x, maxY - y});
        }

        return normalize(rotated);
    }

    boolean isSame(List<int[]> a, List<int[]> b) {
        if (a.size() != b.size()) return false;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) {
                return false;
            }
        }

        return true;
    }

    List<int[]> copyShape(List<int[]> shape) {
        List<int[]> copied = new ArrayList<>();
        for (int[] p : shape) {
            copied.add(new int[]{p[0], p[1]});
        }
        return copied;
    }
}