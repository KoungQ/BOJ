package BOJ.순열_사이클_10451;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class solution {

    static boolean[] visited;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();   // 테스트 케이스 수 입력 받기
        for(int i = 0; i < t; i++) {

            int n = sc.nextInt();   // 순열의 크기 입력 받기
            visited = new boolean[n + 1];   // 크기에 맞게 초기화
            adj = new ArrayList[n + 1];

            for(int j = 1; j < n + 1; j++) {
                adj[j] = new ArrayList<>();
                adj[j].add(sc.nextInt());  // 순열 입력 받기 - 인접 리스트
            }

            int cnt = 0;    // 결과
            for(int j = 1; j < n + 1; j++) {
                if(!visited[j]) {   // 방문하지 않은 요소에 dfs
                    dfs(j);
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }

    static void dfs(int here) {
        visited[here] = true;
        for(int there : adj[here]){
            if(visited[there])
                continue;
            dfs(there);
        }
    }
}
