import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long X = sc.nextLong();
        long Y = sc.nextLong();
        long W = sc.nextLong();   // 가로 세로로 이동 시 드는 비용
        long S = sc.nextLong();   // 대각선으로 이동 시 드는 비용

        long result = 0;

        if (2 * W > S) { // 대각선으로 가르지르는게 더 빠를 경우 == 최대한 대각선으로 이동 후 계산
            if (X > Y) {
                result += S * Y;
                if (X - Y >= 2 && W > S) {
                    result += (((X - Y) / 2) * 2) * S + W * ((X - Y) % 2);
                } else {
                    result += W * (X - Y);
                }
            } else {
                result += S * X;
                if (Y - X >= 2 && W > S) {
                    result += (((Y - X) / 2) * 2) * S + W * ((Y - X) % 2);
                } else {
                    result += W * (Y - X);
                }
            }
        } else {        // 대각선으로 가로지르는게 더 느리거나 같을 경우 == 두번에 걸쳐 가로 세로 이동
            result += W * (X + Y);
        }

        System.out.println(result);
    }
}
