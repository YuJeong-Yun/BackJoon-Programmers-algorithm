import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            int pre = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()) + pre; // 현재 위치 값 = 현재 위치까지 같은 행 누적 합 값
                pre = board[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1, y1 = Integer.parseInt(st.nextToken()) - 1,
                    x2 = Integer.parseInt(st.nextToken()) - 1, y2 = Integer.parseInt(st.nextToken()) - 1,
                    sum = 0;

            for (int j = x1; j <= x2; j++) {
                sum += board[j][y2];
                if (y1 > 0) {
                    sum -= board[j][y1 - 1];
                }
            }
            bw.write(sum + "\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }


}