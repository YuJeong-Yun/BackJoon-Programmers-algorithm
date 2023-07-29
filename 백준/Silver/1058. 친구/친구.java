import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(); // 직접 친구 관계 담을 리스트
        List<HashSet<Integer>> friend = new ArrayList<HashSet<Integer>>(); //  2-친구 관계 담을 리스트
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
            friend.add(new HashSet<>());
        }
        // 직접 친구 관계 저장
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == 'Y') {
                    list.get(i).add(j);
                }
            }
        }

        // 2-친구 관계 찾기
        for (int i = 0; i < N; i++) {
            for (int j : list.get(i)) { // i의 직접 친구
                friend.get(i).add(j);
                for (int k : list.get(j)) { // i의 2-친구
                    friend.get(i).add(k);
                }
            }
        }


        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, friend.get(i).size());
        }
        if (answer > 0) answer -= 1; // 자기 자신은 제외이므로 -1

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();

    }
}