package BOJ.사과담기게임_2828;

import java.util.Scanner;

public class solution {

    static int n, m, j, left, right, ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        j = sc.nextInt();

        left = 1;
//        right = m;    // v1

        for(int i = 0; i < j; i++) {    // 사과 위치 입력 받기
            right = left + m - 1;   // v2
            int place = sc.nextInt();

            if(place >= left && place <= right)     // v2
                continue;

            if(place < left) {      // v2
                ret += (left - place);
                left = place;
            } else {
                left += (place - right);
                ret += (place - right);
            }

//            while(left > place || place > right) {  // 바구나 밖 범위   // v1
//                if(left > place) {  // 바구니가 타겟보다 오른쪽에 있으면
//                    left--;         // 왼쪽으로 한 칸 이동
//                    right--;
//                }
//
//                if(right < place) { // 바구니가 타겟보다 왼쪽에 있으면
//                    left++;         // 오른쪽으로 한 칸 이동
//                    right++;
//                }
//
//                ret++;
//            }
        }

        System.out.println(ret);
    }
}
