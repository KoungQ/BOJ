import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int res = 0;
        for (int i = 1; i <= N; i++)
            if (isSequence(i))
                res++;

        System.out.println(res);
    }

    static boolean isSequence(int N) {
        if (N < 100)
            return true;

        int diff;
        if ((N % 100) / 10 >= N % 10) {
            diff = ((N % 100) / 10) - (N % 10);
            for (int digit = 100; (N / digit) > 0; digit *= 10) {
                if ((N % (digit * 10)) / digit != (N % digit) / (digit / 10) + diff)
                    return false;
            }
        } else {
            diff = (N % 10) - ((N % 100) / 10);
            for (int digit = 100; (N / digit) > 0; digit *= 10) {
                if ((N % (digit * 10)) / digit != (N % digit) / (digit / 10) - diff)
                    return false;
            }
        }
        return true;
    }
}
