import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

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

    
        int TestCase = sc.nextInt();
        for(int TC = 0; TC < TestCase; TC++) {
            int n = sc.nextInt();
            
            for(int i = n / 2; i >= 2; i--) {
                if(num[i] != 0 && num[n - i] != 0) {
                    System.out.printf("%d %d\n", i, n - i);
                    break;                    
                }
            }
        }
    }
}