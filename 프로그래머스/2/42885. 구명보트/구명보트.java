import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right) {
            // 가장 무거운 사람 탑승
            int remain = limit - people[right];
            right--;
            
            // 가벼운 사람 중 가능한 사람 순차 탑승
            if(people[left] <= remain) {
                remain -= people[left];
                left++;
            }
        
            // 보트 출항
            answer++;
        }
        
        return answer;
    }
    
    
}