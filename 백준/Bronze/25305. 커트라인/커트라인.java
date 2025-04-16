import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] scores = new int[N];
        for(int i = 0; i < N; i++)
            scores[i] = sc.nextInt();

        for(int i = 0; i < N - 1; i++)
            for(int j = i + 1; j < N; j++)
                if(scores[i] > scores[j]) {
                    int tmp = scores[i];
                    scores[i] = scores[j];
                    scores[j] = tmp;
                }

        System.out.println(scores[N - k]);
    }
}
