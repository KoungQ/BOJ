import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n, k, temp;
        int[] psum = new int[100001];
        int ret = -10000004;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            temp = sc.nextInt();
            psum[i] = psum[i - 1] + temp;
        }
        for(int i = k; i <= n; i++) {
            int value = psum[i] - psum[i - k];
            if(value > ret)
                ret = value;
        }

        System.out.println(ret);
    }
}
