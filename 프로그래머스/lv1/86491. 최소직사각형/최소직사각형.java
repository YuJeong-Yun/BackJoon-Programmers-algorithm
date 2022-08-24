import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int[] maxArr = new int[sizes.length];
        int[] minArr = new int[sizes.length];
        
        int max, min;
        for(int i = 0; i <  sizes.length; i++) {
            max = Math.max(sizes[i][0], sizes[i][1]);
            min = Math.min(sizes[i][0], sizes[i][1]);
            
            maxArr[i] = max;
            minArr[i] = min;
        }
        
        answer = Arrays.stream(maxArr).max().getAsInt() * Arrays.stream(minArr).max().getAsInt();
        
        
        return answer;
    }
}