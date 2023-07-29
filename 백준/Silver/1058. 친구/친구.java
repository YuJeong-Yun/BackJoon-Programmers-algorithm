import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); // 직접 친구 관계 담을 리스트
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        // 직접 친구 관계 저장
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == 'Y') {
                    graph.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            BFS(i);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();

    }

    public static void BFS(int start) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] ch = new boolean[N];
        int tmp = 0; // 2-친구 수

        ch[start] = true;
        for (int i : graph.get(start)) {
            que.offer(i);
            tmp++;
            ch[i] = true;
        }

        while (!que.isEmpty()) {
            int friend = que.poll();
            for (int friend_2 : graph.get(friend)) {
                if (!ch[friend_2]) {
                    ch[friend_2] = true;
                    tmp++;
                }
            }
        }
        answer = Math.max(answer, tmp);
    }

}