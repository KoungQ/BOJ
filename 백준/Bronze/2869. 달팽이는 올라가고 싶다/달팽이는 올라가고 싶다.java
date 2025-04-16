import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();   // 낮에 올라가는 높이
        int B = sc.nextInt();   // 밤에 미끄러지는 높이
        int V = sc.nextInt();   // 나무 막대 높이

        int days;   // 걸리는 날들
        int height = A - B; // 올라갈 수 있는 높이
        days = (V - B - 1) / height + 1;

        System.out.println(days);
    }
}
