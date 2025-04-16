import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        int flag = 0, level = 1;
        while (flag < X) {
            flag += level;
            level++;
        }
        level--;

        if (level % 2 != 0)   // 홀수
            System.out.printf("%d/%d\n", flag - X + 1, X - (flag - level));
        else
            System.out.printf("%d/%d\n", X - (flag - level), flag - X + 1);
    }

}
