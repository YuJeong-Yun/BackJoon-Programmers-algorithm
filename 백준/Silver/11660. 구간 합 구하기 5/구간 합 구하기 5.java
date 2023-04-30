import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][N];
        int pre = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()) + pre; // 현재 위치 값 = 현재 위치까지 누적 합 값
                pre = board[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1, y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1, y2 = Integer.parseInt(st.nextToken()) - 1;

            int sum = 0;
            if (y1 == 0) {
                if (y2 == N - 1) {  // 한 행의 값이 모두 들어갈 때
                    sum = board[x2][y2];
                    if (x1 > 0) {   // 두 번째 행 이하부터 값이 들어갈 때
                        sum -= board[x1 - 1][N - 1];
                    }
                } else {
                    for (int j = x1; j <= x2; j++) {
                        sum += board[j][y2];
                        if (j > 0) {
                            sum -= board[j - 1][N - 1];
                        }
                    }
                }
            } else {
                for (int j = x1; j <= x2; j++) {
                    sum += board[j][y2];
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