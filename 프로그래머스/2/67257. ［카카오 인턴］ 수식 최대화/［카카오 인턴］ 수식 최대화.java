import java.util.*;

class Solution {
    public long solution(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);

        List<String> opsArr = new ArrayList<>();
        List<Long> numArr = new ArrayList<>();

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("+") || token.equals("-") || token.equals("*")) {
                opsArr.add(token);
            } else {
                numArr.add(Long.parseLong(token));
            }
        }

        String[] ops = {"+", "-", "*"};
        long answer = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                
                for (int k = 0; k < 3; k++) {
                    if (k == i || k == j) continue;

                    String[] priority = {ops[i], ops[j], ops[k]};
                    long val = eval(priority, numArr, opsArr);
                    answer = Math.max(answer, Math.abs(val));
                }
            }
        }

        return answer;
    }

    private long eval(String[] priority, List<Long> nums, List<String> ops) {
        List<Long> n = new ArrayList<>(nums);
        List<String> o = new ArrayList<>(ops);

        for (String op : priority) {    // 각 우선순위마다
            for (int idx = 0; idx < o.size(); ) {   // 모든 인덱스를 돌면서
                if (o.get(idx).equals(op)) {    // 같은게 있다면
                    long a = n.get(idx);
                    long b = n.get(idx + 1);
                    long res = calc(a, b, op);  // 계산

                    n.remove(idx + 1);
                    n.set(idx, res);
                    o.remove(idx);  // 이전 값 소거, 한 자리 지워졌으니 인덱스 그대로
                } else {
                    idx++;  // 같지 않다면 다음 인덱스로
                }
            }
        }

        return n.get(0);
    }

    private long calc(long a, long b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> throw new IllegalArgumentException("op=" + op);
        };
    }
}
