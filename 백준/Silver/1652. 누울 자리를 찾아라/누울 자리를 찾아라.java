import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray(); // 한 줄을 문자 배열로 변환
        }

        int rowResult = 0;
        for(int row = 0; row < n; row++) {  // 가로 한 줄씩 탐색
            int cnt = 0;

            for(int col = 0; col < n; col++) {
                if(map[row][col] == '.') {
                    cnt++;
                } else {
                    if(cnt > 1) {
                        rowResult++;
                    }

                    cnt = 0;
                }
            }

            if(cnt > 1) {
                rowResult++;
            }
        }

        int colResult = 0;
        for(int col = 0; col < n; col++) {  // 가로 한 줄씩 탐색
            int cnt = 0;

            for(int row = 0; row < n; row++) {
                if(map[row][col] == '.') {
                    cnt++;
                } else {
                    if(cnt > 1) {
                        colResult++;
                    }

                    cnt = 0;
                }
            }

            if(cnt > 1) {
                colResult++;
            }
        }

        System.out.println(rowResult + " " + colResult);
    }
}
