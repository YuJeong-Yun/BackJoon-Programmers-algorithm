import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean[] ch;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

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
        ch[V] = true;
        DFS(V);

        sb.append("\n");
        Arrays.fill(ch, false);
        ch[V] = true;
        BFS(V);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int V) {
        sb.append(V + " ");
        for (int i : graph.get(V)) {
            if (!ch[i]) {
                ch[i] = true;
                DFS(i);
            }
        }
    }

    public static void BFS(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        int L = 0;

        sb.append(V + " ");
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int i : graph.get(tmp)) {
                if (!ch[i]) {
                    ch[i] = true;
                    sb.append(i + " ");
                    queue.offer(i);
                }
            }
        }

    }

}
