package BaekJoon.SevenDwarfs_2309;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_v3 {
    static int n = 9;
    static int r = 7;
    static int[] dwarfs = new int[9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++) {
            dwarfs[i] = sc.nextInt();
        }

        makePermutation(n, r, 0);
    }

    static void makePermutation(int n, int r, int depth) {
        if(r == depth) {
            solution();
            return;
        }
        for(int i = depth; i < n; i++) {
            swap(dwarfs[i], dwarfs[depth]);
            makePermutation(n, r, depth + 1);
            swap(dwarfs[i], dwarfs[depth]);
        }
    }

    static void solution() {
        int sum = 0;
        for(int i = 0; i < r; i++) {
            sum += dwarfs[i];
        }
        if(sum == 100) {
            Arrays.sort(dwarfs, 0, r - 1);
            for(int i = 0; i < r; i++)
                System.out.println(dwarfs[i]);

        }
    }

    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
