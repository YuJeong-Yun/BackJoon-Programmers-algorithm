import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int x, y, height;

    public Point(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    public int compareTo(Point p) {
        return p.height - this.height;
    }
}

public class Main {
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int[][] board, cnt;
    static int M, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = new int[M][N]; // 이동 횟수 담을 배열
        cnt[0][0] = 1;
        BFS(new Point(0, 0, board[0][0]));

        bw.write(cnt[M - 1][N - 1] + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void BFS(Point p) {
        PriorityQueue<Point> pQ = new PriorityQueue<>();
        pQ.offer(p);

        while (!pQ.isEmpty()) {
            Point tmp = pQ.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && board[nx][ny] < tmp.height) {
                    if (cnt[nx][ny] == 0) {
                        pQ.offer(new Point(nx, ny, board[nx][ny]));
                    }
                    cnt[nx][ny] += cnt[tmp.x][tmp.y];
                }
            }
        }
    }

}