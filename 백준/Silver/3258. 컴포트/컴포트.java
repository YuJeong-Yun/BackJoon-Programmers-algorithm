import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] field = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            field[Integer.parseInt(st.nextToken()) - 1] = true;
        }

        int answer = 0;
        out:
        for (int i = 1; i <= Z; i++) {
            boolean[] ch = Arrays.copyOf(field, N);
            int pos = 0;
            boolean flag = false;

            while (!ch[pos]) {
                ch[pos] = true;
                pos += i;
                pos %= N;
                if (pos == Z - 1) {
                    answer = i;
                    break out;
                }
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

}