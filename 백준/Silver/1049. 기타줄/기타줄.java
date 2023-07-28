import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int pack = Integer.MAX_VALUE;
        int single = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pack = Math.min(pack, Integer.parseInt(st.nextToken())); // 가장 저렴한 패키지 가격 저장
            single = Math.min(single, Integer.parseInt(st.nextToken())); // 가장 저렴한 낱개 가격 저장
        }

        int answer = 0;
        if (single < ((double) pack / 6)) { // 낱개 가격이 패키지 가격보다 저렴하다면
            answer = N * single;
        } else {
            answer = N / 6 * pack;
            N %= 6;
            if (pack < (N * single)) {
                answer += pack;
            } else {
                answer += N * single;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}