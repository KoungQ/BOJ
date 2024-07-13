package BOJ.팰린드롬인지_확인하기_10988;

import java.util.Scanner;

// 내 풀이 == 강의 풀이
public class Solution_v1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder(input);

        if(sb.reverse().toString().equals(input))
            System.out.println(1);
        else
            System.out.println(0);
    }
}
