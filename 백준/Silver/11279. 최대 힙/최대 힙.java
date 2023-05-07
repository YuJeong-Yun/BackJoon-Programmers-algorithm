import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (pQ.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(pQ.poll() + "\n");
                }
            } else {
                pQ.offer(x);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
