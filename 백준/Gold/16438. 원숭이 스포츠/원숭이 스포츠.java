import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 7;
    static boolean[][] ch;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ch = new boolean[cnt][N];
        for (int i = 0; i < cnt; i++) {
            ch[i][0] = true;
        }

        findTeam(0, 0, N - 1);

        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < N; j++) {
                if (ch[i][j]) bw.write("A");
                else bw.write("B");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void findTeam(int seq, int s, int e) {
        if (seq == cnt || s == e) {
            return;
        }

        int mid = (s + e) / 2;
        for (int i = s; i <= mid; i++) {
            ch[seq][i] = true;
        }

        findTeam(seq + 1, s, mid);
        findTeam(seq + 1, mid + 1, e);
    }


}