import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: 테스트 케이스 개수
        int t = Integer.parseInt(br.readLine());

        // 각 테스트 케이스 처리
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 첫 번째 숫자(케이스 번호) 저장
            int caseNum = Integer.parseInt(st.nextToken());

            // 나머지 20개의 숫자 저장
            int[] heights = new int[20];
            for (int j = 0; j < 20; j++) {
                heights[j] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            List<Integer> students = new ArrayList<>();
            students.add(heights[0]);
            for(int j = 1; j < 20; j++) {
                for(int k = 0; k < students.size(); k++) {
                    if(students.get(k) > heights[j]) {
                        result += students.size() - k;
                        students.add(k, heights[j]);
                        break;
                    }
                }
                if(students.size() <= j)
                    students.add(heights[j]);
            }

            System.out.println(caseNum + " " + result);
        }
    }
}
