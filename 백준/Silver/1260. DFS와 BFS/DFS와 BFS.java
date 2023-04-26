import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V, p = 0;
    static List<ArrayList<Integer>> graph;
    static boolean[] ch;
    static int[] answerDFS, answerBFS;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        ch = new boolean[N + 1];
        answerDFS = new int[N];
        answerBFS = new int[N];

        ch[V] = true;
        DFS(V);
        ch = new boolean[N + 1];
        ch[V] = true;
        BFS(V);

        for (int i : answerDFS) {
            if (i == 0) {
                break;
            }
            bw.write(i + " ");
        }
        bw.write("\n");
        for (int i : answerBFS) {
            if (i == 0) {
                break;
            }
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int V) {
        if (p == N) {
            return;
        }

        answerDFS[p++] = V;
        for (int i = 1; i <= N; i++) {
            if (graph.get(V).contains(i) && !ch[i]) {
                ch[i] = true;
                DFS(i);
            }
        }
    }

    public static void BFS(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        int L = 0;

        answerBFS[L++] = V;
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int i : graph.get(tmp)) {
                if (!ch[i]) {
                    ch[i] = true;
                    answerBFS[L++] = i;
                    queue.offer(i);
                }
            }
        }

    }

}
