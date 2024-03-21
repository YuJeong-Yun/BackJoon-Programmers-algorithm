
import java.io.*;
import java.util.*;

class Food {
    int S;
    int B;

    public Food(int S, int B) {
        this.S = S;
        this.B = B;
    }
}

public class Main {
    public static int N;
    public static List<Food> list = new ArrayList<>();
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list.add(new Food(S, B));
        }

        DFS(0, 0, 1, 0);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int L, int cnt, int sSum, int bSum) {
        if (L == N) {
            if (cnt > 0) {
                answer = Math.min(answer, Math.abs(sSum - bSum));
            }
            return;
        }
        Food tmp = list.get(L);
        DFS(L + 1, cnt + 1, sSum * tmp.S, bSum + tmp.B); // L 인덱스의 요리 포함 O
        DFS(L + 1, cnt, sSum, bSum); // L 인덱스의 요리 포함 X
    }
}
