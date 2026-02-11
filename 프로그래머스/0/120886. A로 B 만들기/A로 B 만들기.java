class Solution {
    
    int[] alphabet = new int[26];
    
    public int solution(String before, String after) {
        for(char c : before.toCharArray()) {
            alphabet[c - 'a']++;
        }
        
        for(char c : after.toCharArray()) {
            alphabet[c - 'a']--;
        }
        
        for(int a : alphabet) {
            if(a != 0)
                return 0;
        }
        
        return 1;
    }
}