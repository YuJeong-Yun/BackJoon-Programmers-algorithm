import java.awt.image.ImageProducer;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N;
    static int[] answer, tmp;
    static char[][] sign;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        answer = new int[N];
        tmp = new int[N];

        String s = br.readLine();
        sign = new char[N][N];
        int p = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sign[i][j] = s.charAt(p++);
            }
        }

        DFS(0);

        for (int i : answer) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int L) {
        if (flag) {
            return;
        } else if (L == N) {
            flag = true;
            answer = Arrays.copyOf(tmp, N);
            return;
        }

        for (int i = -10; i <= 10; i++) {
            tmp[L] = i;

            boolean check = true;
            int sum = 0;
            for (int j = L; j >= 0; j--) {
                sum += tmp[j];
                if (sum == 0 && sign[j][L] != '0') {
                    check = false;
                } else if (sum > 0 && sign[j][L] != '+') {
                    check = false;
                } else if (sum < 0 && sign[j][L] != '-') {
                    check = false;
                }
            }
            if (check) {
                DFS(L + 1);
            }
        }
    }


}