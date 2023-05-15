import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            long[] dp = new long[N + 1];

            if (N <= 3) {
                bw.write("1\n");
            } else if (N <= 5) {
                bw.write("2\n");
            } else {
                dp[1] = dp[2] = dp[3] = 1;
                dp[4] = dp[5] = 2;

                for (int j = 6; j <= N; j++) {
                    dp[j] = dp[j - 1] + dp[j - 5];
                }
                bw.write(dp[N] + "\n");
            }

        }


        bw.flush();
        bw.close();
        br.close();

    }

}