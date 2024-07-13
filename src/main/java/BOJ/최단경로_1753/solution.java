package BOJ.최단경로_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class solution {
    static ArrayList[] l;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());   // 정점의 개수
        int E = Integer.parseInt(st.nextToken());   // 간선의 개수
        int K = Integer.parseInt(br.readLine()) - 1;    // 시작 정점의 번호

        l = new ArrayList[V];
        dist = new int[V];

        for(int i = 0; i < V; i++) {
            l[i] = new ArrayList<Node>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < E; i++){   // 간선 연결
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;   // 간선 시작 지점
            int v = Integer.parseInt(st.nextToken()) - 1;   // 간선 끝 지점
            int w = Integer.parseInt(st.nextToken());   // 간선 가중치

            l[u].add(new Node(v, w));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < V; i++){
            if(dist[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            int len = l[now.v].size();
            for(int i = 0; i < len; i++){
                Node next = (Node) l[now.v].get(i);

                if(dist[next.v] > now.w + next.w){
                    dist[next.v] = now.w + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int v, w;

    public Node(int v, int w){
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node n){
        return this.w - n.w;
    }
}
