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

        int[] dyF = new int[N + 1], dyB = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && dyF[j] > max) {
                    max = dyF[j];
                }
            }
            dyF[i] = max + 1;
        }

        for (int i = N; i >= 1; i--) {
            int max = 0;
            for (int j = N; j > i; j--) {
                if (arr[i] > arr[j] && dyB[j] > max) {
                    max = dyB[j];
                }
            }
            dyB[i] = max + 1;
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dyF[i] + dyB[i] - 1);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();

    }

}