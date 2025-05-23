import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] grades = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                grades[i][0] = Integer.parseInt(st.nextToken()); // 서류 등수
                grades[i][1] = Integer.parseInt(st.nextToken()); // 면접 등수
            }

            Arrays.sort(grades, Comparator.comparingInt(a -> a[0]));

            int result = 1;
            int minInterview = grades[0][1];

            for (int i = 1; i < N; i++) {
                if (grades[i][1] < minInterview) {
                    result++;
                    minInterview = grades[i][1];
                }
            }

            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}
