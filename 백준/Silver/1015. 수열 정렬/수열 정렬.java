import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N], A2 = new int[N]; 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = A2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A2);
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            Queue<Integer> que = map.getOrDefault(A2[i], new LinkedList<>());
            que.add(i);
            map.put(A2[i], que);
        }

        for (int i = 0; i < N; i++) {
            bw.write(map.get(A[i]).poll()+" ");
        }


        bw.flush();
        bw.close();
        br.close();
    }

}