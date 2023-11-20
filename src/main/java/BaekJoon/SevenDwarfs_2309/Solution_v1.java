package BaekJoon.SevenDwarfs_2309;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_v1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] height = new int[9];
        for(int i = 0; i < 9; i++) {
            height[i] = sc.nextInt();
            sum += height[i];
        }

        Arrays.sort(height);
        for(int i = 0; i < 9; i++)
            for(int j = i + 1; j < 9; j++)
                if(height[i] + height[j] == sum - 100) {
                    for(int k = 0; k < 9; k++)
                        if(k != i && k != j)
                            System.out.println(height[k]);
                    return;
                }
    }
}
