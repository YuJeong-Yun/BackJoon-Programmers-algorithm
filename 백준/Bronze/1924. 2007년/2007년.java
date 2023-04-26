import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

        int days = 0;
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1; i < x; i++) {
            days += months[i];
        }
        days += y;

        String[] yoil = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        bw.write(yoil[days % 7]);

        bw.flush();
        bw.close();
        br.close();
    }

}
