import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] alphaCnt = new int[26];

        for (char c : s.toCharArray())
            alphaCnt[c - 97]++;

        for (int i : alphaCnt)
            System.out.print(i + " ");
    }
}
