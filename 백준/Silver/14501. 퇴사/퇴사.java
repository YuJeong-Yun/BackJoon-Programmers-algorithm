import java.io.*;
import java.util.*;

class Work {
    int startDay, endDay, money;

    public Work(int startDay, int endDay, int money) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.money = money;
    }

    @Override
    public String toString() {
        return this.startDay + " " + this.endDay + " " + this.money + ";";
    }
}

public class Main {
    static int N;
    static Work[] arr;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new Work[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startDay = i;
            int endDay = Integer.parseInt(st.nextToken()) + i - 1; // 상담이 끝나는 날(1~7)
            int money = Integer.parseInt(st.nextToken());
            if (endDay > N) { // 종료일이 N일 초과
                arr[i] = new Work(startDay, startDay, 0);
            } else {
                arr[i] = new Work(startDay, endDay, money);
            }
        }

        DFS(1, 0);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int startDay, int sum) {
        if (startDay > N) {
            answer = Math.max(answer, sum);
            return;
        }

        Work w = arr[startDay];
        DFS(w.endDay + 1, sum + w.money);
        DFS(startDay + 1, sum);


    }


}