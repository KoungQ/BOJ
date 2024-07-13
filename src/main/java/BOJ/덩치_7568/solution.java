package BOJ.덩치_7568;

import java.util.Scanner;

public class solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int memberCnt = sc.nextInt();

        int[][] members = new int[memberCnt][];

        for (int i = 0; i < memberCnt; i++) {   // 키 몸무게 입력
            int weight = sc.nextInt();
            int height = sc.nextInt();

            members[i] = new int[]{weight, height};
        }

        for (int i = 0; i < memberCnt; i++) {   // 등수 찾기
            int rank = 1;
            for (int j = 0; j < memberCnt; j++) {
                if (i == j)
                    continue;

                if (members[i][0] < members[j][0]
                        && members[i][1] < members[j][1])
                    rank++;
            }
            System.out.print(rank + " ");   // 출력
        }
    }
}