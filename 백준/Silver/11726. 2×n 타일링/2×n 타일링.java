import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dy = new int[N + 1];
        dy[1] = 1;
        if (N > 1) {
            dy[2] = 2;
            for (int i = 3; i <= N; i++) {
                dy[i] = (dy[i - 2] + dy[i - 1]) % 10007;
            }
        }

        bw.write(dy[N] + "");
        bw.flush();
        bw.close();
        br.close();

    }

}