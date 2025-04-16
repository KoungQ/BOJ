import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[5];
        int avg = 0;
        for(int i = 0; i < 5; i++) {
            num[i] = sc.nextInt();
            avg += num[i];
        }
        for(int i = 0; i < 4; i++)
            for(int j = i + 1; j < 5; j++)
                if(num[i] > num[j]) {
                    int tmp = num[i];
                    num[i] = num[j];
                    num[j] = tmp;
                }

        System.out.println(avg / 5);
        System.out.println(num[2]);
    }
}
