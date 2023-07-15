import java.io.*;
import java.util.*;

public class Main {
    static int[][] fibo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        fibo = new int[41][2];
        fibo[0][0] = fibo[1][1] = 1;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            fibonacci(N, 0);
            fibonacci(N, 1);
            bw.write(fibo[N][0] + " " + fibo[N][1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int fibonacci(int n, int digit) {
        if (n == 0 || n == 1) {
            return fibo[n][digit];
        } else if (n == digit) {
            return 1;
        } else if (fibo[n][digit] != 0) {
            return fibo[n][digit];
        } else {
            return fibo[n][digit] = fibonacci(n - 1, digit) + fibonacci(n - 2, digit);
        }
    }
}