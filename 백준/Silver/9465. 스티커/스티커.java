import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n+1];

            int[][] dy = new int[2][n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine()), st2 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                sticker[0][j] = Integer.parseInt(st.nextToken());
                sticker[1][j] = Integer.parseInt(st2.nextToken());
            }

            dy[0][1] = sticker[0][1];
            dy[1][1] = sticker[1][1];
            for (int j = 2; j <= n; j++) {
                dy[0][j] = Math.max(dy[1][j - 1], dy[1][j - 2]) + sticker[0][j];
                dy[1][j] = Math.max(dy[0][j - 1], dy[0][j - 2]) + sticker[1][j];
            }

            bw.write(Math.max(dy[0][n], dy[1][n]) + "\n");


        }


        bw.flush();
        bw.close();
        br.close();

    }

}