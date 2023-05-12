import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[][] dy = new long[N + 1][2];
        dy[1][1] = 1;

        for (int i = 2; i <= N; i++) {
            dy[i][0] = dy[i - 1][0] + dy[i - 1][1];
            dy[i][1] = dy[i - 1][0];
        }

        long answer = dy[N][0] + dy[N][1];
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();

    }

}