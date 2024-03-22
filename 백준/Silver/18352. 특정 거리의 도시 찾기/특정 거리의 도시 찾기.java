
import java.io.*;
import java.util.*;

public class Main {
    public static int K;
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] ch;
    public static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        ch = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
        }

        BFS(X);

        if (answer.isEmpty()) {
            bw.write("-1");
        } else {
            Collections.sort(answer);
            for (int n : answer) {
                bw.write(n + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void BFS(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        ch[V] = true;

        int level = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int tmp = queue.poll();
                for (int next : graph.get(tmp)) {
                    if (!ch[next]) {
                        ch[next] = true;
                        if (level == K) {
                            answer.add(next);
                        } else {
                            queue.offer(next);
                        }
                    }
                }
            }
            level++;
        }
    }
}
