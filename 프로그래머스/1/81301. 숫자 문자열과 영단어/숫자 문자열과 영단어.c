import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<String, String> words = new HashMap<>();
        initWords(words);
        
        for(Entry<String, String> entry : words.entrySet()) {
            s = s.replace(entry.getKey(), entry.getValue());
        }
        
        answer = Integer.parseInt(s);
        return answer;
    }
    
    public void initWords(Map<String, String> words) {
        words.put("zero", "0");
        words.put("one", "1");
        words.put("two", "2");
        words.put("three", "3");
        words.put("four", "4");
        words.put("five", "5");
        words.put("six", "6");
        words.put("seven", "7");
        words.put("eight", "8");
        words.put("nine", "9");
    }
}