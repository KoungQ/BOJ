import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
      
        int sum = 0;
	    int min = 10000;
		int[] num = new int[10001];
		
		for(int i=0; i <= 1; i++) 
			num[i] = 0;
		
		for(int i=2; i <= 10000; i++) 
			num[i] += i;
		
		for(int i=2; i <= 10000; i++) {
			if(num[i] == 0) continue;
			
			for(int j=i+i; j <= 10000; j+=i) {
				num[j] = 0;
			}
		}
            
        for(int i = M; i <= N; i++) {
            if(num[i] != 0) {
                sum += num[i];
                
                if(num[i] < min)
                    min = num[i];
            }
        }
        
    if(sum == 0)
        System.out.println(-1);
    else
        System.out.printf("%d\n%d", sum, min);
    }
}