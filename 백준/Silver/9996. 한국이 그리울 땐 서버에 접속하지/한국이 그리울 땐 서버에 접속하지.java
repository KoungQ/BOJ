import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        sc.nextLine();

        String input = sc.nextLine();
        String[] pattern = input.split("\\*");

        for (int i = 0; i < line; i++) {
            input = sc.nextLine();
            if (input.length() < pattern[0].length() + pattern[1].length())
                System.out.println("NE");
            else {
                if (input.startsWith(pattern[0]) && input.endsWith(pattern[1]))
                    System.out.println("DA");
                else
                    System.out.println("NE");
            }
        }

    }
}
