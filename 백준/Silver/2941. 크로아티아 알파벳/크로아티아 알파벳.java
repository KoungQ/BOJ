import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] Alphabet = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        int wordCnt = 0;
        for(int i = 0; i < Alphabet.length; i++) {
            while(word.contains(Alphabet[i])) {
                word = word.replaceFirst(Alphabet[i], " ");
                wordCnt++;
            }
        }
        word = word.replaceAll(" ", "");
        wordCnt += word.length();

        System.out.println(wordCnt);
    }
}
