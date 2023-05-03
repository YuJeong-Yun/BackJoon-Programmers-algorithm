import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }

        int answer = 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken()); // 꺼내야할 수

            int cnt = 0;
            while (que.peek() != num) {
                que.offer(que.poll());
                cnt++;
            }

            answer += Math.min(cnt, que.size() - cnt);
            que.poll();
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
