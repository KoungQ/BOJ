import java.util.Scanner;
 
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		            1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		            1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		            
		for(int i = 0; i < 28; i++) {
		    int a = sc.nextInt();
		    arr[a - 1] = 0;
		}
		
		for(int i = 0; i < 30; i++)
		    if(arr[i] != 0)
	            System.out.println(i + 1);
	}
}