package BOJ.트럭주차_2979;

import java.util.Scanner;

// 강의 풀이
public class Solution_v2 {
    public static void main(String[] args) {
        int A, B, C, a, b, ret = 0;
        int[] cnt = new int[104];

        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        for(int i = 0; i < 3; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            for(int j = a; j < b; j++)
                cnt[j]++;
        }

        for(int j = 1; j < 100; j++) {
            if(cnt[j] != 0) {
                if(cnt[j] == 1)
                    ret += A;
                else if(cnt[j] == 2)
                    ret += B * 2;
                else if(cnt[j] == 3)
                    ret += C * 3;
            }
        }

        System.out.println(ret);
    }
}
