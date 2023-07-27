import java.io.*;
import java.util.*;

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
        for (int i = 0; i < M; i++) {
            Arrays.fill(cnt[i], -1); // 방문 체크 위해 -1로 초기화
        }

        DFS(M - 1, N - 1);

        bw.write(cnt[M - 1][N - 1] + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int DFS(int x, int y) {
        if (cnt[x][y] != -1) return cnt[x][y];
        if (x == 0 && y == 0) return 1;

        cnt[x][y] = 0; // 방문 체크
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && board[nx][ny] > board[x][y]) {
                cnt[x][y] += DFS(nx, ny);
            }
        }
        return cnt[x][y];

    }


}