import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int v, w;

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge e) {
        return this.w - e.w;
    }
}

public class Main {
    static List<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
    static int V, E;
    static int[] dis;
    static boolean[] ch;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        dis = new int[V + 1];
        ch = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
        }

        Arrays.fill(dis, Integer.MAX_VALUE);
        dijkstra(K);
        for (int i = 1; i <= V; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            } else {
                bw.write(dis[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra(int K) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        ch[K] = true;
        dis[K] = 0;
        for (Edge e : graph.get(K)) {
            pQ.offer(e);
        }

        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            if (ch[tmp.v]) {
                continue;
            } else {
                ch[tmp.v] = true;
                dis[tmp.v] = tmp.w;
                for (Edge e : graph.get(tmp.v)) {
                    pQ.offer(new Edge(e.v, tmp.w + e.w));
                }
            }
        }


    }

}