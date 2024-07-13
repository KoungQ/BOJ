package BOJ.바이러스_2606;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class solution {

    static ArrayList<Integer>[] adj;
    static int[] visited;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 컴퓨터 개수 입력 받기
        int pair = sc.nextInt();   // 컴퓨터 쌍의 개수 입력받기

        visited = new int[n + 1];    // 컴퓨터 수 만큼 boolean 배열 만들기
        adj = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < pair; i++) {     // 컴퓨터 쌍 입력받기
            int from = sc.nextInt();
            int to = sc.nextInt();
            adj[from].add(to);
            adj[to].add(from);
        }

        bfs(1);

        System.out.println(cnt);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = 1;
        queue.add(start);
        while(!queue.isEmpty()){
            int here = queue.poll();
            for(int there : adj[here]){
                if(visited[there] > 0)
                    continue;
                visited[there] = visited[here] + 1;
                queue.add(there);
                cnt++;
            }
        }
    }
}
