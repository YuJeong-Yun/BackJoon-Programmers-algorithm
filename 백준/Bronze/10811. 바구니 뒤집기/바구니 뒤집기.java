import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] basket = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            basket[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int lt = Integer.parseInt(st.nextToken());
            int rt = Integer.parseInt(st.nextToken());
            int cnt = (int) Math.ceil((rt - lt) / (double)2);

            for (int j = 0; j < cnt; j++) {
                int tmp = basket[rt];
                basket[rt] = basket[lt];
                basket[lt] = tmp;
                lt++;
                rt--;
            }
        }

        for (int i = 1; i <= N; i++) {
            bw.write(basket[i] + " ");

        }

        bw.flush();
        bw.close();
        br.close();
    }
}