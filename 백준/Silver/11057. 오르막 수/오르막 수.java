import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] dy = new int[N + 1][11];

        for (int i = 0; i < 10; i++) {
            dy[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k >= 0; k--) {
                    dy[i][j] = (dy[i - 1][k] + dy[i][j]) % 10007;
                }
            }
        }

        int answer = 0;
        for (int i : dy[N]) {
            answer = (answer + i) % 10007;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();

    }

}