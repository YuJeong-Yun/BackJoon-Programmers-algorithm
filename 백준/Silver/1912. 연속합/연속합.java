import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dy = new int[N + 1];
        int min = 0, answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            dy[i] = dy[i - 1] + arr[i];
            answer = Math.max(answer, dy[i] - min);
            min = Math.min(min, dy[i]);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();

    }

}