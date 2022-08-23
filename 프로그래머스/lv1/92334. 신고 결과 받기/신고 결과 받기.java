import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        answer = new int[id_list.length];
        
        List<String> idList = Arrays.asList(id_list);
        // id_list 순서대로 신고당한 횟수 저장
        int[] reportCnt = new int[id_list.length];
        // key: 신고당한 회원, value:신고한 회원 리스트
        Map<String, ArrayList<String>> reportMap = new HashMap<>();
        

        StringTokenizer st;
        String userId, reportId;
        ArrayList<String> userIdList = null;
        for(int i=0; i<report.length; i++) {
            st = new StringTokenizer(report[i]);
            
            userId = st.nextToken();
            reportId = st.nextToken();
            
            
            
            if(reportMap.containsKey(reportId)) {
                userIdList = reportMap.get(reportId);
                if(userIdList.contains(userId)) {
                    continue;
                }
                userIdList.add(userId);
            }else {
                userIdList = new ArrayList<>();
                userIdList.add(userId);
            }
            reportCnt[idList.indexOf(reportId)]++;
            reportMap.put(reportId, userIdList);
        }
        
        for(int i=0; i<reportCnt.length; i++) {
            if(reportCnt[i] >= k) {
                userIdList = reportMap.get(id_list[i]);
                for(int j=0; j<userIdList.size(); j++) {
                    answer[idList.indexOf(userIdList.get(j))]++;
                }
            }
        }
        
        
        return answer;
    }
}