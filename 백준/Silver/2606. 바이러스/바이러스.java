
import java.io.*;
import java.util.*;

public class Main {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] ch;
    public static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        ch = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        BFS(1);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void BFS(int V) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(V);
        ch[V] = true;

        while (!que.isEmpty()) {
            int tmp = que.poll();
            for (int next : graph.get(tmp)) {
                if (!ch[next]) {
                    ch[next] = true;
                    que.offer(next);
                    answer++;
                }
            }
        }

    }
}
