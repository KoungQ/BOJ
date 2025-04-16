import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N, sum, res, cycle = 0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

            if(N < 10)
                N *= 10;
            res = N;
        do{
            sum = (res / 10) + (res % 10);
            res = (res % 10) * 10 + (sum % 10);
            cycle++;
        } while(N != res);

        System.out.println(cycle);
    }
}
