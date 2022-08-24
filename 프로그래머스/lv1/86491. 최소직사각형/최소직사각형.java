import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
            
        int max = 0, min = 0;
        for(int i = 0; i <  sizes.length; i++) {
            int tempMax = Math.max(sizes[i][0], sizes[i][1]);
            int tempMin = Math.min(sizes[i][0], sizes[i][1]);
            
            max = Math.max(max, tempMax);
            min = Math.max(min, tempMin);
        }
        
        answer = max*min;
        
        
        return answer;
    }
}