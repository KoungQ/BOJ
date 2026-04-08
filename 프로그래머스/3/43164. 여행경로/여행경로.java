import java.util.*;

class Solution {
    Map<String, List<String>> graph;
    String[] answer;
    int ticketCount;
    boolean found = false;

    public String[] solution(String[][] tickets) {
        graph = new HashMap<>();
        ticketCount = tickets.length;

        for (String[] ticket : tickets) {
            graph.computeIfAbsent(ticket[0], k -> new ArrayList<>()).add(ticket[1]);
        }

        for (List<String> list : graph.values()) {
            Collections.sort(list);
        }

        List<String> result = new ArrayList<>();
        result.add("ICN");

        dfs("ICN", result, 0);

        return answer;
    }

    void dfs(String here, List<String> result, int used) {
        if (found)
            return;

        if (used == ticketCount) {
            answer = result.toArray(new String[0]);
            found = true;
            return;
        }

        List<String> path = graph.get(here);
        if (path == null || path.isEmpty())
            return;

        for (int i = 0; i < path.size(); i++) {
            String next = path.remove(i);
            result.add(next);

            dfs(next, result, used + 1);

            if (found)
                return;

            result.remove(result.size() - 1);
            path.add(i, next);
        }
    }
}