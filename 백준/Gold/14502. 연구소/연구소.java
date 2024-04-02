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
    public static int N, M;
    public static int[][] board;
    public static List<Point> virus = new ArrayList<>();
    public static List<Point> nothings = new ArrayList<>();
    public static int nothing = 0;
    public static int[] newWall = new int[3];
    public static int answer = 0;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static boolean[][] ch;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                if (num == 0) {
                    nothing++;
                    nothings.add(new Point(i, j));
                } else if (num == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }
        nothing -= 3;
        DFS(0, 0);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int L, int tmp) {
        if (L == 3) {
            for (int idx : newWall) {
                Point wall = nothings.get(idx);
                board[wall.x][wall.y] = 1;
            }

            int total = 0;
            ch = new boolean[N][M];
            for (Point p : virus) {
                total += BFS(p);
            }
            answer = Math.max(answer, nothing - total);

            for (int idx : newWall) {
                Point wall = nothings.get(idx);
                board[wall.x][wall.y] = 0;
            }
            return;
        }

        for (int i = tmp; i < nothings.size(); i++) {
            newWall[L] = i;
            DFS(L + 1, i + 1);
        }
    }

    public static int BFS(Point p) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(p);

        int cnt = 0;
        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !ch[nx][ny] && board[nx][ny] == 0) {
                    ch[nx][ny] = true;
                    cnt++;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        return cnt;
    }

}