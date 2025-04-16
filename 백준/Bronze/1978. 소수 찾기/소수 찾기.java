import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int[] num = new int[N];
      int cnt = 0;
      
      for(int i = 0; i < N; i++) {
          num[i] = sc.nextInt();
          
            if(num[i] == 1)
                num[i] = 0;
            else {
                for(int j = 2; j < num[i] - 1; j++) {
                    if(num[i] % j == 0)
                        num[i] = 0;
                }
            }
            
            if(num[i] != 0)
                cnt++;
      }
      System.out.println(cnt);
    }
}