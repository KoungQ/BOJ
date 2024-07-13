package BOJ.에라토스테네스의_체_2960;

import java.util.Scanner;

public class solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        isPrime(N, K);
    }

    static void isPrime(int N, int K){ // 시간복잡도 O(N)
        boolean[] prime = new boolean[N + 1];
        for(int i = 2; i <= N; i++){
            // prime[i]가 소수라면
            if(!prime[i]){
                // prime[j] 소수가 아니라면
                for(int j = i; j <= N; j += i) {
                    if(K == 1 && !prime[j])
                        System.out.println(j);

                    if(!prime[j])
                        K--;

                    prime[j] = true;
                }
            }
        }
    }
}
