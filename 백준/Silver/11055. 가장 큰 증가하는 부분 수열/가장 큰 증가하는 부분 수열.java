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
        int answer = dy[1] = arr[1];
        for (int i = 2; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && dy[j] > sum) {
                    sum = dy[j];
                }
            }
            dy[i] = sum + arr[i];
            answer = Math.max(answer, dy[i]);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();

    }

}