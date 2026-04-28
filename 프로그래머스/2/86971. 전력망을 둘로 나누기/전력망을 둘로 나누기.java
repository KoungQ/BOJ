class Solution {
    boolean[] visited;
    int count;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int cut = 0; cut < wires.length; cut++) {
            visited = new boolean[n + 1];
            count = 0;

            dfs(wires, wires[cut][0], cut);

            int other = n - count;
            int diff = Math.abs(count - other);

            answer = Math.min(answer, diff);
        }

        return answer;
    }

    void dfs(int[][] wires, int here, int cut) {
        visited[here] = true;
        count++;

        for (int i = 0; i < wires.length; i++) {
            if (i == cut) 
                continue;

            int a = wires[i][0];
            int b = wires[i][1];

            if (a == here && !visited[b]) {
                dfs(wires, b, cut);
            }

            if (b == here && !visited[a]) {
                dfs(wires, a, cut);
            }
        }
    }
}