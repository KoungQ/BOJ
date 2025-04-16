import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int hours, minutes, times, resTime;

        Scanner sc = new Scanner(System.in);
        hours = sc.nextInt();
        minutes = sc.nextInt();
        times = sc.nextInt();

        resTime = (hours * 60) + minutes + times;
        resTime %= 3600;

        System.out.printf("%d %d", (resTime / 60) % 24, resTime % 60);
    }
}
