import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int vex, cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
        return this.cost - e.cost;
    }
}

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, E, v1, v2;
    static List<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
    static long v1_1, v2_1, v1_N, v2_N, v1_v2;
    static int[] dis;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        dijkstra(1);
        v1_1 = dis[v1];
        v2_1 = dis[v2];
        dijkstra(N);
        v1_N = dis[v1];
        v2_N = dis[v2];
        dijkstra(v1);
        v1_v2 = dis[v2];

        long result1 = v1_1 + v2_N + v1_v2;
        long result2 = v1_N + v2_1 + v1_v2;
        if (result1 >= INF && result2 >= INF) {
            answer = -1;
        } else if (result1 >= INF) {
            answer = (int) result2;
        } else if (result2 >= INF) {
            answer = (int) result1;
        } else {
            answer = (int) Math.min(result1, result2);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra(int n) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(n, 0));

        dis = new int[N + 1];
        Arrays.fill(dis, INF);
        dis[n] = 0;

        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            for (Edge e : graph.get(tmp.vex)) {
                if (dis[e.vex] > tmp.cost + e.cost) {
                    dis[e.vex] = tmp.cost + e.cost;
                    pQ.offer(new Edge(e.vex, tmp.cost + e.cost));
                }
            }
        }
    }

}