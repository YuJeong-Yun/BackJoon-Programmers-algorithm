import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        if (p.x == this.x) {
            return this.y - p.y;
        }
        return this.x - p.x;

    }

}

public class Main {
    static int N, size = 2, eat = 0, answer = 0, dist = 1;
    static int[][] board;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static boolean[][] ch;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        Point tmp = null;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                if (num == 9) {
                    tmp = new Point(i, j);
                    board[i][j] = 0;
                } else if (num == 1) {
                    flag = true;
                }
            }
        }

        if (flag) {
            BFS(tmp);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void BFS(Point p) {
        Queue<Point> que = new LinkedList<>();
        que.offer(p);
        ch = new boolean[N][N];
        ch[p.x][p.y] = true;

        out:
        while (!que.isEmpty()) {
            int len = que.size();
            List<Point> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                Point tmp = que.poll();
                for (int j = 0; j < dx.length; j++) {
                    int nx = tmp.x + dx[j], ny = tmp.y + dy[j];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !ch[nx][ny] && board[nx][ny] <= size) {
                        ch[nx][ny] = true;
                        list.add(new Point(nx, ny));
                        que.offer(new Point(nx, ny));
                    }
                }
            }
            Collections.sort(list);
            for (Point next : list) {
                int nx = next.x, ny = next.y;
                if (board[nx][ny] > 0 && board[nx][ny] < size) { // 먹을 수 있는 물고기
                    board[nx][ny] = 0;
                    eat++;
                    answer += dist;
                    dist = 1;
                    if (eat == size) { // 현재 크기만큼 물고기 먹으면
                        size++;
                        eat = 0;
                    }
                    que.clear();
                    que.offer(new Point(nx, ny));
                    ch = new boolean[N][N];
                    ch[nx][ny] = true;
                    continue out;
                }
            }
            dist++;
        }
    }


}