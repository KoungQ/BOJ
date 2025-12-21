class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            answer[i] = isValidRoom(places[i]) ? 1 : 0;
        }

        return answer;
    }

    // 5개 방이 유효한지 검사
    private boolean isValidRoom(String[] room) {
        char[][] map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            map[i] = room[i].toCharArray();
        }

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (map[r][c] == 'P') { // 응시자 발견 시
                    if (isViolation(map, r, c)) // 거리두기 위반 여부 검사
                        return false;
                }
            }
        }
        return true;    // 모두가 위반하지 않았다면 true
    }

    private boolean isViolation(char[][] map, int r, int c) {

        // 직선 거리 1 (즉시 위반)
        int[][] lineDist1 = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}    // 1칸 상하좌우
        };

        for (int[] d : lineDist1) {
            int nr = r + d[0];
            int nc = c + d[1];
            
            if (inRange(nr, nc) && map[nr][nc] == 'P') {
                return true;    // 상하좌우에 또 사람이 존재할경우 true (위반 O)
            }
        }

        // 직선 거리 2 (중간 칸 확인)
        int[][] lineDist2 = {
            {-2, 0}, {2, 0}, {0, -2}, {0, 2}    // 2칸 상하좌우
        };

        for (int[] d : lineDist2) {
            int nr = r + d[0];
            int nc = c + d[1];
            
            if (!inRange(nr, nc))   // 범위 밖일 경우 패스
                continue;

            if (map[nr][nc] == 'P') {   // 사람 발견
                int midR = r + d[0] / 2;
                int midC = c + d[1] / 2;
                
                if (map[midR][midC] != 'X') {   // 사이에 장애물이 없을 시 
                    return true;    // 위반 O
                }
            }
        }

        // 대각선 거리 2 (사이 2칸 모두 확인)
        int[][] diagonalDist2 = {
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}  // 대각선
        };

        for (int[] d : diagonalDist2) {
            int nr = r + d[0];
            int nc = c + d[1];
            
            if (!inRange(nr, nc))   // 범위 밖이면 패스
                continue;

            if (map[nr][nc] == 'P') {   // 사람 발견
                int side1R = r;
                int side1C = c + d[1];
                int side2R = r + d[0];
                int side2C = c;

                if (map[side1R][side1C] != 'X' ||
                    map[side2R][side2C] != 'X') {   // 장애물 없을 시
                    return true;    // 위반 O
                }
            }
        }

        return false;
    }

    // 5x5 범위 밖인지 검사
    private boolean inRange(int r, int c) {
        return r >= 0 && r < 5 && c >= 0 && c < 5;
    }
}
