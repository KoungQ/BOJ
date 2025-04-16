import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        double avg = 0.0;
        int biggest = 0;
        int scores[] = new int[N];
        for(int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
            if(biggest < scores[i])
                biggest = scores[i];
        }
        for(int i = 0; i < N; i++) {
            avg += ((double)scores[i] / biggest) * 100;
        }
        avg /= N;

        System.out.println(avg);
    }
}
