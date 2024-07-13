package BOJ.농구경기_1159;

import java.util.Scanner;

// 내 풀이 == 강의 풀이
public class Solution_v1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        sc.nextLine();

        int[] alphaCnt = new int[26];
        for (int i = 0; i < cnt; i++) {
            String input = sc.nextLine();
            alphaCnt[input.toCharArray()[0] - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        boolean isExist = false;
        for(int i = 0; i < alphaCnt.length; i++) {
            if(alphaCnt[i] >= 5) {
                result.append((char) (i + 'a'));
                isExist = true;
            }
        } if(!isExist)
            System.out.println("PREDAJA");
        System.out.println(result);
    }
}
