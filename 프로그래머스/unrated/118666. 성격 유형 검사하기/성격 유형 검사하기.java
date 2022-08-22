class Solution {
    // 순서대로 R,T,C,F,J,M,A,N
    public static int[] scores = new int[8];
    
    public static void calcScore(char category, int score) {
        switch(category) {
            case 'R':
                scores[0] += score;
                break;
            case 'T':
                scores[1] += score;
                break;
            case 'C':
                scores[2] += score;
                break;
            case 'F':
                scores[3] += score;
                break;
            case 'J':
                scores[4] += score;
                break;
            case 'M':
                scores[5] += score;
                break;
            case 'A':
                scores[6] += score;
                break;
            case 'N':
                scores[7] += score;
                break;
        }
    }
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
    
        for(int i=0 ;i<survey.length ;i++) {
            if(choices[i] <= 3) {
                calcScore(survey[i].charAt(0), 4-choices[i]);
            }else if(choices[i] >= 5) {
                calcScore(survey[i].charAt(1), choices[i]-4);
            }
        }
        

        answer += scores[0] >= scores[1] ? "R" : "T";
        answer += scores[2] >= scores[3] ? "C" : "F";
        answer += scores[4] >= scores[5] ? "J" : "M";
        answer += scores[6] >= scores[7] ? "A" : "N";
        
        return answer;
    }
}