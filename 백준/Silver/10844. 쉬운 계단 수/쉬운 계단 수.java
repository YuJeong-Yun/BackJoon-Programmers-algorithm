import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] dy = new int[N + 1][10];
        for (int i = 1; i < 10; i++) {
            dy[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            dy[i][0] = dy[i - 1][1];
            for (int j = 1; j < 9; j++) {
                dy[i][j] = (dy[i - 1][j - 1] + dy[i - 1][j + 1]) % 1000000000;
            }
            dy[i][9] = dy[i - 1][8];
        }

        int answer = 0;
        for (int i : dy[N]) {
            answer = (answer + i) % 1000000000;
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();

    }

}