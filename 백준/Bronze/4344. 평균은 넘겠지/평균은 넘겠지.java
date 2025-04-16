import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();

        for(int TestCase = 0; TestCase < C; TestCase++) {
            double avg = 0.0;
            int N = sc.nextInt();
            int[] scores = new int[N];

            for(int i = 0; i < N; i++) {
                scores[i] = sc.nextInt();
                avg += scores[i];
            }
            avg /= N;

            double res = 0;
            for(int i = 0 ; i < N; i++) {
                if(scores[i] > avg)
                    res++;
            }
            res = (res / N) * 100;

            System.out.printf("%.3f%%\n", res);
        }
    }
}
