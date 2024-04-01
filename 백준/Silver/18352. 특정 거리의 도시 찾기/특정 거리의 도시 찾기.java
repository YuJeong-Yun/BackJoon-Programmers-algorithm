
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static int K;
    public static int N;
    public static List<List<Integer>> graph = new ArrayList<>();
    public static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()); // 시작점
        dist = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
        }

        DFS(0, X);
        dist[X] = 0;


        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                flag = true;
                sb.append(i + "\n");
            }
        }
        if (flag) {
            System.out.println(sb);
        } else {
            bw.write("-1");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int L, int node) {
        if (L > K) {
            return;
        }

        for (int tmp : graph.get(node)) {
            if (dist[tmp] > L + 1) {
                dist[tmp] = L + 1;
                DFS(L + 1, tmp);
            }
        }
    }
}
