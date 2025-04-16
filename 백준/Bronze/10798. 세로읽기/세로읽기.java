import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] input = new char[5][15];
        String result = "";

        int maxLen = 0;
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 5; i++) {
            String str = sc.next();
            for(int j = 0; j < str.length(); j++) {
                input[i][j] = str.charAt(j);
            }
            if(str.length() > maxLen)
                maxLen = str.length();
        }

        for(int i = 0; i < maxLen; i++) {
            for(int j = 0; j < 5; j++) {
                if(input[j][i] == 0) {
                    continue;
                }

                result += input[j][i];
            }
        }

        System.out.println(result);
    }
}
