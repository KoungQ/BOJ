package BOJ.수열_2559;

import java.util.Scanner;

// 강의 풀이: 구간 합

/**
 *      연속된 합이 최대/최소가 되는 구간 == 구간 합
 *      구간 합(prefix sum): psum[i] = psum[i - 1] + a[i];
 *      "최댓값을 구하라" : 최솟값부터 최댓값을 구하라
 *      "최솟값을 구하라" : 최댓값부터 최솟값을 구하라
 */

public class Solution_v2 {
    public static void main(String[] args) {
        int n, k, temp;
        int[] psum = new int[100001];
        int ret = -10000004;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            temp = sc.nextInt();
            psum[i] = psum[i - 1] + temp;
        }

        for(int i = k; i <= n; i++) {
            int value = psum[i] - psum[i - k];
            if(value > ret)
                ret = value;
        }

        System.out.println(ret);
    }
}
