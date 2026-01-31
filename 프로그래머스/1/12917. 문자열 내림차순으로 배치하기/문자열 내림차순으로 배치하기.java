import java.util.*;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        return new StringBuilder(String.valueOf(arr))
                .reverse()
                .toString();
    }
}
