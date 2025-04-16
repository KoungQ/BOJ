import java.util.Scanner;

public class Main {
    static String solution(int[][] yuts) {
        StringBuilder answer = new StringBuilder();

        for (int[] yut : yuts) {
            int BackCnt = 0;

            for (int j = 0; j < yut.length; j++) {
                if (yut[j] == 1)
                    BackCnt++;
            }

            if (BackCnt == 4) {
                answer.append("E");
            } else if (BackCnt == 3) {
                answer.append("A");
            } else if (BackCnt == 2) {
                answer.append("B");
            } else if (BackCnt == 1) {
                answer.append("C");
            } else {
                answer.append("D");
            }
            answer.append("\n");
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] yut = new int[3][4];

        for(int i = 0; i < yut.length; i++) {
            for(int j = 0; j < yut[0].length; j++) {
                yut[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(yut));
    }
}
