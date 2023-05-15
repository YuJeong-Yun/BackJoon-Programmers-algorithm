import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int max = 0;
        List<Long> list = new ArrayList<>();

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long n = Long.parseLong(br.readLine());
            map.put(n, map.getOrDefault(n, 0) + 1);

            int cnt = map.get(n);
            if (cnt > max) {
                max = cnt;
                list.clear();
                list.add(n);
            } else if (max == cnt) {
                list.add(n);
            }
        }
        Collections.sort(list);

        bw.write(list.get(0) + "");
        bw.flush();
        bw.close();
        br.close();

    }

}