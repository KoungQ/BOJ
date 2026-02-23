import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> numbers = new HashSet<>(Arrays.asList(phone_book));

        for (String phone : phone_book) {
            for (int j = 1; j < phone.length(); j++) {
                String prefix = phone.substring(0, j);
                if (numbers.contains(prefix)) 
                    return false;
            }
        }
        return true;
    }
}