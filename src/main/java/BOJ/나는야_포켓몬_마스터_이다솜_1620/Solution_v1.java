package BOJ.나는야_포켓몬_마스터_이다솜_1620;

import java.util.Scanner;

// 시간 초과
// 내 풀이
public class Solution_v1 {
    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(System.in);

            int pokemonCnt = sc.nextInt();
            String[] pokemon = new String[pokemonCnt];
            int problemCnt = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < pokemonCnt; i++) {
                pokemon[i] = sc.nextLine();
            }

            for (int i = 0; i < problemCnt; i++) {
                String problem = sc.nextLine();

                if (problem.matches("[0-9]+")) {
                    System.out.println(pokemon[Integer.parseInt(problem) - 1]);
                }
                else {
                    for (int j = 0; j < pokemonCnt; j++) {
                        if (pokemon[j].equals(problem)) {
                            System.out.println(j + 1);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}