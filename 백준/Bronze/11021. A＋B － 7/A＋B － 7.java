import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        
        for(int i = 0; i < TC; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
             
            System.out.printf("Case #%d: %d\n", i + 1, a + b);
        }
    }
}