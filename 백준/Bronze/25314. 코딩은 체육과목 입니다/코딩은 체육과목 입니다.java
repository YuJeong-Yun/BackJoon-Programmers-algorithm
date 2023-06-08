import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int cnt = N / 4 - 1;
        StringBuilder sb = new StringBuilder("long int");

        while (cnt > 0) {
            sb.insert(0, "long ");
            cnt--;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}