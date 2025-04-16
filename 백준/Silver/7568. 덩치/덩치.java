import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int memberCnt = sc.nextInt();

        int[][] members = new int[memberCnt][];

        for(int i = 0; i < memberCnt; i++) {
            int weight = sc.nextInt();
            int height = sc.nextInt();

            members[i] = new int[] {weight, height};
        }

        for(int i = 0; i < memberCnt; i++) {
            int rank = 1;
            for(int j = 0; j < memberCnt; j++) {
                if(i == j) {
                    continue;
                }
                
                if(members[i][0] < members[j][0] && members[i][1] < members[j][1])
                    rank++;

            }
            System.out.print(rank + " ");
        }
    }
}