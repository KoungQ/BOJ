import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int totalPrice = sc.nextInt();
        int num = sc.nextInt();
        
        int price = 0;
        for(int i = 0; i < num; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            price += a * b;
        }
        if(price == totalPrice)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}