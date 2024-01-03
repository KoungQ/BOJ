package BaekJoon.MakePalindrome_1213;

import java.util.Scanner;

public class Solution_v1 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            int[] alphaCnt = new int[26];

            for (char c : input.toCharArray()) {
                alphaCnt[c - 'A']++;
            }

            StringBuilder result = new StringBuilder();
            for(int i = alphaCnt.length - 1; i >= 0; i--) {
                if(alphaCnt[i] == 0)
                    continue;

                if(alphaCnt[i] % 2 == 0) {
                    for(int j = 0; j < alphaCnt[i] / 2; j++) {
                        result.insert(0, (char) (i + 'A'));
                        result.append((char) (i + 'A'));
                    }
                } else {
                    for(int j = 0; j < alphaCnt[i]; j++)
                        if(result.length() / 2 == 0)
                            result.append((char) (i + 'A'));
                        else {
                            if(j >= 1) {
                                result.insert(0, (char) (i + 'A'));
                                result.append((char) (i + 'A'));
                                j++;
                            } else {
                                result.insert(result.length() / 2, (char) (i + 'A'));
                            }

                        }
                }
            }


            String resultString = result.toString();
            String reverse = result.reverse().toString();

            if(resultString.equals(reverse))
                System.out.println(result);
            else
                System.out.println("I'm Sorry Hansoo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
