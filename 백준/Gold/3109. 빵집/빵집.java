import java.awt.*;
import java.util.*;
import java.io.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int R, C;
    static boolean[][] board;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static int answer = 0;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new boolean[R][C]; // .:true, x:false

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                if (s.charAt(j) == '.') {
                    board[i][j] = true;
                }
            }
        }

        for (int i = 0; i < R; i++) { // 각 행의 첫 번째 열에서 출발
            flag = false;
            DFS(i, 0);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int x, int y) {
        if (flag) {
            return;
        }
        if (y == C - 1) {
            answer++;
            flag = true;

            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < R && ny < C && board[nx][ny]) {
                if(flag) return;
                board[nx][ny] = false;
                DFS(nx, ny);
            }
        }
    }


}