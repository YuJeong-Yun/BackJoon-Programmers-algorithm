import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][2]; // 0열:기간, 1열:금액

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            arr[i][0] = day;
            arr[i][1] = money;
        }

        // dy -> i일에 얻을 수 있는 최대 금액
        // 돈을 다음날 받는다고 가정 & 마지막날 기간이 1일인 경우 있을 수 있으므로 => N+2
        int[] dy = new int[N + 2];
        int max = 0; // i일차 최대금액
        for (int i = 1; i <= N; i++) {
            if (dy[i] > max) {
                max = dy[i];
            }

            int nxt = i + arr[i][0]; // i일차 작업 끝냈을 때 날짜
            // ex) 2일차 => nxt = 2 + 5 = 7
            if (nxt < N + 2) { // i일차 작업을 퇴사 전까지 완료할 수 있을 경우
                dy[nxt] = Math.max(dy[nxt], max + arr[i][1]);
            }
        }
        max = Math.max(max, dy[N + 1]);

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }

}