import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
	    int min = 246912;
		int[] num = new int[246913];
		    
		for(int i=0; i <= 1; i++) 
		  	num[i] = 0;
		    
		for(int i=2; i <= 246912; i++) 
		  	num[i] += i;
		    
		for(int i=2; i <= 246912; i++) {
		   	if(num[i] == 0) continue;
		    	
		    for(int j=i+i; j <= 246912; j+=i) {
		    	num[j] = 0;
		    }
		}

        while(true) {
            int n = sc.nextInt();
            if(n == 0)
                break;
            
            int cnt = 0;
            for(int i = n + 1; i <= n * 2; i++) {
                if(num[i] != 0)
                    cnt++;
            }
            System.out.println(cnt);
        }  
    }
}