import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                bw.write("*");
            }
            for (int j = 1; j <= 2 * N - 2 * i; j++) {
                bw.write(" ");
            }
            for (int j = 1; j <= i; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        for (int i = 1; i < N; i++) {
            for (int j = N - i; j >= 1; j--) {
                bw.write("*");
            }
            for (int j = 2 * i; j >= 1; j--) {
                bw.write(" ");
            }
            for (int j = N - i; j >= 1; j--) {
                bw.write("*");
            }
            bw.write("\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
