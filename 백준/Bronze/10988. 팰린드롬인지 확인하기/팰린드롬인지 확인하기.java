import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuffer sb = new StringBuffer(input);

        if(sb.reverse().toString().equals(input))
            System.out.println(1);
        else
            System.out.println(0);
    }
}
