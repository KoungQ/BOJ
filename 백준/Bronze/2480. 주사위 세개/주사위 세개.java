import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int FirstEyes, SecondEyes, ThirdEyes, res;

        Scanner sc = new Scanner(System.in);
        FirstEyes = sc.nextInt();
        SecondEyes = sc.nextInt();
        ThirdEyes = sc.nextInt();

        if(FirstEyes == SecondEyes || FirstEyes == ThirdEyes) {
            if(SecondEyes == ThirdEyes) {
                res = 10000 + FirstEyes * 1000;
            }
            else {
                res = 1000 + FirstEyes * 100;
            }
        }
        else if(SecondEyes == ThirdEyes) {
            res = 1000 + SecondEyes * 100;
        }
        else {
            int biggest = FirstEyes;
            if(biggest < SecondEyes)
                biggest = SecondEyes;
            if(biggest < ThirdEyes)
                biggest = ThirdEyes;

            res = biggest * 100;
        }

        System.out.println(res);
    }
}
