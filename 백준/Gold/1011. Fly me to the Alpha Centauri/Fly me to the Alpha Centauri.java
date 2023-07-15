import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int dist = y - x; // 이동해야 할 거리값
            int max = (int) Math.sqrt(dist); // 이동 최대값

            int count = 0; // 이동 횟수
            if (dist == max * max) { // dist에 루트 씌운 값이 max랑 같을 경우
                count = max * 2 - 1;
            } else if (dist <= max * max + max) { // 절반 기준으로 1 증가
                count = max * 2;
            } else { // 절반 기준으로 2 증가
                count = max * 2 + 1;
            }
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}