import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int GroupWord = 0;
        for(int wordCnt = 0; wordCnt < N; wordCnt++) {
						// 알파벳 a~z가 26개
            int[] Alp = new int[26];

            String word = sc.next();
						// 초기값 = true
            boolean isGrouped = true;
            for(int i = 0; i < word.length(); i++) {
								// 처음 등장한 알파벳이라면
                if(Alp[word.charAt(i) - 'a'] == 0) {
										// 이미 등장했다는 표시를 해주고
                    Alp[word.charAt(i) - 'a']++;
										// 같은 단어라면 스킵하고,
                    if(i < word.length() - 1)
                        while(word.charAt(i) == word.charAt(i + 1)) {
                            i++;
                            if(i == word.length() - 1)
                                break;
                        }
                }
                else {
                    isGrouped = false;
                    break;
                }
            }
            if(isGrouped == true)
                GroupWord++;
        }

        System.out.println(GroupWord);
    }
}