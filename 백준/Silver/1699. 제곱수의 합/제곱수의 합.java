import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dy = new int[N + 1];
        dy[1] = 1;
        for (int i = 2; i <= N; i++) {
            int sq = (int) Math.sqrt(i);
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= sq; j++) {
                min = Math.min(min, dy[i - j * j]);
            }
            dy[i] = min + 1;
        }

        bw.write(dy[N] + "");
        bw.flush();
        bw.close();
        br.close();

    }

}