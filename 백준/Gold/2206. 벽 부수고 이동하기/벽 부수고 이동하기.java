import java.io.*;
import java.util.*;

class Point {
    int x, y, dist, drill;

    public Point(int x, int y, int dist, int drill) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.drill = drill;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", dist=" + dist +
                ", drill=" + drill +
                '}';
    }
}

public class Main {
    static int N, M;
    static int[][] board;
    static int[][] ch;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ch = new int[N][M];
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j) - '0';
                ch[i][j]=Integer.MAX_VALUE;
            }
        }

        int answer = BFS(0, 0);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int BFS(int x, int y) {
        Queue<Point> que = new ArrayDeque<>();
        que.offer(new Point(x, y, 1, 0));

        while (!que.isEmpty()) {
            Point tmp = que.poll();
//            System.out.println(tmp);
            if (tmp.x == N - 1 && tmp.y == M - 1) {
                return tmp.dist;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = tmp.x + dx[i], ny = tmp.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (ch[nx][ny] > tmp.drill) {
                        if (board[nx][ny] == 0) {
                            que.offer(new Point(nx, ny, tmp.dist + 1, tmp.drill));
                            ch[nx][ny] = tmp.drill;
                        } else {
                            if (tmp.drill == 0) {
                                que.offer(new Point(nx, ny, tmp.dist + 1, 1));
                                ch[nx][ny] = 1;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

}