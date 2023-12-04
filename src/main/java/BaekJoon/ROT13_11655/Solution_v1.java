package BaekJoon.ROT13_11655;

import java.util.Scanner;

public class Solution_v1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (('a' <= c && c <= 'z')
                    || ('A' <= c && c <= 'Z')) {
                if(('a' <= c && c <= 'm')
                        || c <= 'M') {
                    result.append((char) (c + 13));
                } else {
                    result.append((char) (c - 13));
                }
            } else {
                result.append(c);
            }
        }

        System.out.println(result);
    }
}
