

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] balloons = new int[N]; // 풍선 안 값 (풍선 터졌으면 0)
        for (int i = 0; i < N; i++) {
            balloons[i] = Integer.parseInt(st.nextToken());
        }


        bw.write("1 ");
        int pos = 0; // 현재 풍선 위치

        for (int i = 0; i < N - 1; i++) {
            int move = balloons[pos];
            balloons[pos] = 0;

            while (move > 0) {
                pos = ++pos % N;
                if (balloons[pos] != 0) {
                    move--;
                }
            }
            while (move < 0) {
                pos = --pos < 0 ? N - 1 : pos;
                if (balloons[pos] != 0) {
                    move++;
                }
            }
            bw.write(pos + 1 + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}