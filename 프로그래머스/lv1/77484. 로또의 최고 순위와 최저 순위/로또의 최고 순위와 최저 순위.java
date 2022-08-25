import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        answer = new int[2];
        
        int cnt=0, cnt0=0;
        Arrays.sort(win_nums);
        for(int i=0; i<lottos.length; i++) {
            if(lottos[i]==0) {
                cnt0++;
            }else {
                for(int j=0; j<win_nums.length; j++) {
                    if(win_nums[j] == lottos[i]) {
                        cnt++;
                    }else if(win_nums[j] > lottos[i]) {
                        break;
                    }
                }
            }
        }
        
        answer[0] = cnt+cnt0 == 0 ? 6 : 7-(cnt+cnt0);
        answer[1] = cnt==0 ? 6 : 7-cnt;
        
        return answer;
    }
}