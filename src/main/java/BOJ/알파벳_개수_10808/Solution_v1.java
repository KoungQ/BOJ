package BOJ.알파벳_개수_10808;

import java.util.Scanner;

// 내 풀이
public class Solution_v1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] alphaCnt = new int[26];
        for (char c : s.toCharArray())
            alphaCnt[c - 'a']++;

        for (int i : alphaCnt)
            System.out.print(i + " ");
    }
}