package BOJ.트럭주차_2979;

import java.util.Scanner;

// 내 풀이 1
public class Solution_v1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalFare = 0;
        int[] fare = new int[3];
        int[] allTime = new int[100];
        int min = 101;
        int max = 0;

        for(int i = 0; i < fare.length; i++)
            fare[i] = sc.nextInt();
        for(int i = 0; i < fare.length; i++) {
            int start = sc.nextInt();
            if(min > start)
                min = start;

            int end = sc.nextInt() - 1;
            if(max < end)
                max = end;

            for(int time = start; time <= end; time++)
                allTime[time - 1]++;
        }

        for(int time = min; time <= max; time++)
            if(allTime[time - 1] != 0)
                totalFare += allTime[time - 1] * fare[allTime[time - 1] - 1];

        System.out.println(totalFare);
    }
}
