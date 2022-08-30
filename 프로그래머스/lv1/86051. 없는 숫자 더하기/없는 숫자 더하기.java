import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] digit = new boolean[10];
        
        for(int i=0; i<numbers.length; i++) {
            digit[numbers[i]] = true;
        }
        
        for(int i=0; i<digit.length; i++) {
            if(!digit[i]) {
                answer += i;
            }
        }

        return answer;
    }
}