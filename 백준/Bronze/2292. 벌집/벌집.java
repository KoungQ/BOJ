import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //int i = 1;
        //for(int roomCnt = 1; (N - 1) > )

        int flag = 1;
        int roomCnt = 1;
        while(N > flag) {
            flag += 6 * roomCnt;
            roomCnt++;
        }

        System.out.println(roomCnt);
    }
}
