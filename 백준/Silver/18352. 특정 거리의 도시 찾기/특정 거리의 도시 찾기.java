import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, k, x;
    static List<Integer>[] graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 도시 개수
        m = Integer.parseInt(st.nextToken());   // 도로 개수
        k = Integer.parseInt(st.nextToken());   // 거리 정보
        x = Integer.parseInt(st.nextToken());   // 출발 도시 번호

        graph = new ArrayList[n + 1];
        visited = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }


        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
        }

        bfs(x);

        boolean isExist = false;
        for(int i = 1; i <= n; i++)
            if(visited[i] == k + 1) {
                System.out.println(i);
                isExist = true;
            }
        if(!isExist)
            System.out.println(-1);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = 1;
        queue.add(start);
        while(!queue.isEmpty()){
            int here = queue.poll();
            for(int there : graph[here]){
                if(visited[there] > 0)
                    continue;
                visited[there] = visited[here] + 1;
                queue.add(there);
            }
        }
    }
}
