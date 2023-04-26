import java.io.*;
import java.util.*;

public class Main {
    static boolean[] ch;
    static int[] calc = {3, 2, -1};
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ch = new boolean[N + 1];
        ch[N] = true;

        BFS(N);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void BFS(int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int k = 0; k < len; k++) {
                int tmp = queue.poll();
                if (tmp == 1) {
                    return;
                }
                for (int i = 0; i < calc.length; i++) {
                    if (i == 2) {
                        int next = tmp + calc[i];
                        if (!ch[next]) {
                            ch[next] = true;
                            queue.offer(next);
                        }
                    } else {
                        int next = tmp / calc[i];
                        if (tmp % calc[i] == 0 && !ch[next]) {
                            ch[next] = true;
                            queue.offer(next);
                        }
                    }
                }
            }
            answer++;
        }

    }

}
