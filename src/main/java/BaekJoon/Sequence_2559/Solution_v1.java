package BaekJoon.Sequence_2559;

import java.util.Scanner;

// 내 풀이
public class Solution_v1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tmpCnt = sc.nextInt();
        int cntRange = sc.nextInt();
        int[] seq = new int[tmpCnt];

        for (int i = 0; i < tmpCnt; i++) {
            seq[i] = sc.nextInt();
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = cntRange - 1; i < tmpCnt; i++) {
            int sum = 0;
            for (int j = 0; j < cntRange; j++) {
                sum += seq[i - j];
            }

            if(maxSum < sum)
                maxSum = sum;
        }

        System.out.println(maxSum);
    }
}
