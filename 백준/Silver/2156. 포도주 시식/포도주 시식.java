import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        int[] grape = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            grape[i] = Integer.parseInt(br.readLine());
        }

        int[] dy = new int[N + 1];
        dy[1] = grape[1];
        if (N > 1) {
            dy[2] = dy[1] + grape[2];

            for (int i = 3; i <= N; i++) {
                dy[i] = Math.max(Math.max(dy[i - 2], dy[i - 3] + grape[i - 1]) + grape[i], dy[i - 1]);
            }
        }

        bw.write(dy[N] + "");
        bw.flush();
        bw.close();
        br.close();

    }

}