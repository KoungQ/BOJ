import java.util.Scanner;

public class Main {

    static int n, m, j, left, right, ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        j = sc.nextInt();

        left = 0;
        right = m - 1;

        for(int i = 0; i < j; i++) {    // 사과 위치 입력 받기
            int place = sc.nextInt();

            while(left > place || place > right) {  // 바구나 밖 범위
                if(left > place) {  // 바구니가 타겟보다 오른쪽에 있으면
                    left--;         // 왼쪽으로 한 칸 이동
                    right--;
                }

                if(right < place) { // 바구니가 타겟보다 왼쪽에 있으면
                    left++;         // 오른쪽으로 한 칸 이동
                    right++;
                }

                ret++;
            }
        }

        System.out.println(ret - 1);
    }
}
