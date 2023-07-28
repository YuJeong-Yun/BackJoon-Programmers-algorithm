import java.io.*;
import java.util.*;

class Edge {
    int s, e, cost;

    public Edge(int s, int e, int cost) {
        this.s = s;
        this.e = e;
        this.cost = cost;
    }

}

public class Main {
    static int N, M;
    static List<Edge> list = new ArrayList<>();
    static Long[] dis;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dis = new Long[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 시작 정점
            int B = Integer.parseInt(st.nextToken()); // 도착 정점
            int C = Integer.parseInt(st.nextToken()); // 가중치

            list.add(new Edge(A, B, C));
        }
        Arrays.fill(dis, Long.MAX_VALUE);

        if (bellmanford(1) == -1) { // 음수 사이클 있으면
            bw.write(-1 + "");
        } else {
            for (int i = 2; i <= N; i++) {
                if (dis[i] == Long.MAX_VALUE) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(dis[i] + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bellmanford(int start) {
        dis[start] = 0L;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge e = list.get(j);

                if (dis[e.s] == Long.MAX_VALUE) continue;
                if (dis[e.s] + e.cost < dis[e.e]) {
                    if (i == N - 1) { // N번째 탐색에서 값이 되는 것은 음수 사이클이 존재함을 의미
                        return -1;
                    }
                    dis[e.e] = dis[e.s] + e.cost;
                }
            }
        }
        return 1;
    }

}