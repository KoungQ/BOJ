import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        int big = 0;
        int cmpA = A;   int cmpB = B;
        do {
            if(cmpA % 10 > cmpB % 10) {
                big = A;
                break;
            }
            else if(cmpA % 10 < cmpB % 10) {
                big = B;
                break;
            }

            cmpA /= 10;
            cmpB /= 10;
        } while(cmpA != 0 || cmpB != 0);

        int res = (big % 10) * 100 + ((big / 10) % 10) * 10 + (big / 100);
        System.out.println(res);
    }
}
