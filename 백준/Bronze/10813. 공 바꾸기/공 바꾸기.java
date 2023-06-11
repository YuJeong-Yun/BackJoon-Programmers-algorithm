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

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int tmp = basket[j];
            basket[j] = basket[i];
            basket[i] = tmp;
        }


        for (int i = 1; i <= N; i++) {
            bw.write(basket[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}