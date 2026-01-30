import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        
        Set<Integer> made = new HashSet<>();
        boolean[] used = new boolean[numbers.length()];
        StringBuilder sb = new StringBuilder();

        dfs(numbers, used, sb, made);
        
        for(int x : made)
            if(isPrime(x))
                answer++;
        
        return answer;
    }
    
    private void dfs(String numbers, boolean[] used, StringBuilder sb, Set<Integer> made) {
        if (sb.length() > 0) {
            made.add(Integer.parseInt(sb.toString()));
        }

        if (sb.length() == numbers.length()) 
            return;

        for (int i = 0; i < numbers.length(); i++) {
            if (used[i]) 
                continue;

            used[i] = true;
            sb.append(numbers.charAt(i));

            dfs(numbers, used, sb, made);

            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
    
    private boolean isPrime(int n) {
        if (n < 2) 
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;

        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        
        return true;
    }
}