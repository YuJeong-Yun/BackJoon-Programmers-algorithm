import java.io.*;
import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int M, N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            boolean[][] board = new boolean[N][M]; // 배추밭 - true:배추가 있는 땅
            for (int j = 0; j < K; j++) { // 배추의 위치 표시
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()); // 가로 좌표
                int x = Integer.parseInt(st.nextToken()); // 세로 좌표

                board[x][y] = true;
            }

            int answer = 0;
            boolean[][] ch = new boolean[N][M]; //
            for (int j = 0; j < N; j++) { // 배추가 있는 위치에서 BFS로 갈 수 있는 위치 board에서 false로 변경
                for (int k = 0; k < M; k++) {
                    if (board[j][k]) {
                        BFS(new Point(j, k), board);
                        answer++;
                    }
                }
            }

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void BFS(Point p, boolean[][] board) {
        Queue<Point> que = new LinkedList<>();
        que.offer(p);
        board[p.x][p.y] = false;

        while (!que.isEmpty()) {
            Point tmp = que.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny]) {
                    board[nx][ny] = false;
                    que.offer(new Point(nx, ny));
                }
            }
        }
    }

}