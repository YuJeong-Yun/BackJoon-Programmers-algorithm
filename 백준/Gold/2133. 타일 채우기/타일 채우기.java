import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dy = new int[N + 1];
        dy[0] = 1;
        if (N > 1) {
            dy[2] = 3;
        }
        if (N > 3) {
            dy[4] = 11;
        }
        if (N > 5) {
            dy[6] = 6 + 33 + 2;
        }
        for (int i = 8; i <= N; i += 2) {
            dy[i] = dy[i - 2] * 3;
            for (int j = 4; j <= i; j += 2) {
                dy[i] += dy[i - j] * 2;
            }
        }

        bw.write(dy[N] + "");
        bw.flush();
        bw.close();
        br.close();

    }

}