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
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int h, w, answer;
    public static boolean[] key;
    public static char[][] board;
    public static List<Point> entranceList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            answer = 0;
            key = new boolean[26];
            entranceList = new ArrayList<>();

            board = new char[h][w];
            for (int j = 0; j < h; j++) {
                String s = br.readLine();
                for (int k = 0; k < w; k++) {
                    char c = s.charAt(k);
                    board[j][k] = c;

                    if (j == 0 || j == h - 1 || k == 0 || k == w - 1) if (c != '*') {
                        entranceList.add(new Point(j, k));
                        if (c == '$') {
                            answer++;
                            board[j][k] = '.';
                        } else if (Character.isLowerCase(c)) {
                            key[c - 'a'] = true;
                        }
                    }

                }
            }
            String s = br.readLine();
            if (!s.equals("0")) {
                for (int j = 0; j < s.length(); j++) {
                    key[s.charAt(j) - 'a'] = true;
                }
            }

            boolean restart = BFS();
            while (restart) {
                restart = BFS();
            }

            sb.append(answer + "\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static boolean BFS() {
        Queue<Point> queue = new LinkedList<>();

        boolean[][] ch = new boolean[h][w];
        for (Point entrance : entranceList) {
            char c = board[entrance.x][entrance.y];
            if (Character.isUpperCase(c) && !key[c - 'A']) {
                continue;
            }
            queue.offer(entrance);
            ch[entrance.x][entrance.y] = true;
        }

        while (!queue.isEmpty()) {
            Point tmp = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w && board[nx][ny] != '*' && !ch[nx][ny]) {
                    char nChar = board[nx][ny];
                    if (Character.isUpperCase(nChar) && !key[nChar - 'A']) {
                        continue;
                    }
                    if (nChar == '$') {
                        answer++;
                        board[nx][ny] = '.';
                    } else if (Character.isLowerCase(nChar) && !key[nChar - 'a']) {
                        key[nChar - 'a'] = true;
                        return true;
                    }
                    ch[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        return false;
    }
}