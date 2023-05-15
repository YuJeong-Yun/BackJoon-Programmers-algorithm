import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        A = new int[K + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        double pr = N;
        for (int i = 1; i <= K; i++) {
            double temp = 0.0;
            temp += pr * (1 - (double) A[i] / N) + (N - pr) * ((double) A[i] / N);
            pr = temp;
        }

        bw.write(pr + "");
        bw.flush();
        bw.close();
        br.close();
    }


}