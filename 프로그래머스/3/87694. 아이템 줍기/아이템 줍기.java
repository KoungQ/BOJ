import java.util.*;

class Solution {

    static final int SIZE = 102;
    static final int EMPTY = 0;
    static final int BORDER = 1;
    static final int INNER = 2;

    int[][] map = new int[SIZE][SIZE];
    boolean[][] visited = new boolean[SIZE][SIZE];

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rect : rectangle) {
            fillRectangle(rect);
        }

        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    // 테두리와 내부를 구분하기 위해 선을 두배로 굵게 칠함.
    void fillRectangle(int[] rect) {
        int x1 = rect[0] * 2;
        int y1 = rect[1] * 2;
        int x2 = rect[2] * 2;
        int y2 = rect[3] * 2;

        for (int y = y1; y <= y2; y++) {
            for (int x = x1; x <= x2; x++) {
                if (x > x1 && x < x2 && y > y1 && y < y2) {
                    map[y][x] = INNER;
                } else {
                    if (map[y][x] != INNER) {
                        map[y][x] = BORDER;
                    }
                }
            }
        }
    }

    int bfs(int startX, int startY, int targetX, int targetY) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startX, startY, 0));
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == targetX && current.y == targetY) {
                return current.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE) {
                    continue;
                }

                if (visited[ny][nx]) {
                    continue;
                }

                if (map[ny][nx] != BORDER) {
                    continue;
                }

                visited[ny][nx] = true;
                queue.offer(new Node(nx, ny, current.dist + 1));
            }
        }

        return 0;
    }

    static class Node {
        int x;
        int y;
        int dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}