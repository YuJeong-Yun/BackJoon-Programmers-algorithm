import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                bw.write(" ");
            }
            for (int j = 0; j < 2 * N - 1 - i * 2; j++) {
                bw.write("*");
            }
            bw.write(" \n");
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N - i; j++) {
                bw.write(" ");
            }
            for (int j = 1; j <= i * 2 + 1; j++) {
                bw.write("*");
            }

            bw.write(" \n");
        }

        bw.flush();
        bw.close();
        br.close();
    }


}
