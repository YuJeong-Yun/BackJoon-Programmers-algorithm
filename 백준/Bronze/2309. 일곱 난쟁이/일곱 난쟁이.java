import java.io.*;
import java.util.*;

public class Main {
    static int total = 100, cnt1 = 9, cnt2 = 7;
    static int[] heights;
    static int[] answer, tmp;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        heights = new int[cnt1];
        answer = new int[cnt2];
        tmp = new int[cnt2];
        for (int i = 0; i < cnt1; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        DFS(0, 0, 0);

        Arrays.sort(answer);
        for (int i : answer) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int L, int i, int sum) {
        if (flag) {
            return;
        } else if (i == cnt2 && sum == total) {
            flag = true;
            answer = Arrays.copyOf(tmp, cnt2);
            return;
        } else if (L == cnt1 || i == cnt2 || sum >= total) {
            return;
        }

        DFS(L + 1, i, sum);

        tmp[i] = heights[L];
        DFS(L + 1, i + 1, sum + heights[L]);
        tmp[i] = 0;
    }
}
