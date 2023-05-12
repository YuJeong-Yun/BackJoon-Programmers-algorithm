import java.io.*;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] dy = new int[n + 1];
            dy[1] = 1;
            if (n > 1) dy[2] = 2;
            if (n > 2) dy[3] = 4;
            for (int j = 4; j <= n; j++) {
                dy[j] = dy[j - 3] + dy[j - 2] + dy[j - 1];
            }
            bw.write(dy[n] + "\n");
        }


        bw.flush();
        bw.close();
        br.close();

    }

}