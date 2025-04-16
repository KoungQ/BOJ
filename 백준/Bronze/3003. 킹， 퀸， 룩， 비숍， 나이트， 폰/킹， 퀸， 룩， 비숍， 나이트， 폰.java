import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] a = {1, 1, 2, 2, 2, 8};
        int[] b = new int[6];
        
        for(int i = 0; i < 6; i ++) {
            b[i] = sc.nextInt();
        
            System.out.print(a[i] - b[i] + " ");
        
        }
    }
}