import java.util.Scanner;
 
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
		    arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		int cnt = 0;
		for(int i = 0; i < n; i++) {
		    if(arr[i] == target)
		        cnt++;
		}
		
	    System.out.println(cnt);
	}
}