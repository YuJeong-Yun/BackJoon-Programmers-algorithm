
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());

        int answer = 0;
        int basketS = 0;
        int basketE = M - 1;
        for (int i = 0; i < J; i++) {
            int pos = Integer.parseInt(br.readLine()) - 1;

            if (pos >= basketS && pos <= basketE) {
                continue;
            } else if (pos < basketS) {
                answer += basketS - pos;
                basketS = pos;
                basketE = pos + M - 1;
            } else {
                answer += pos - basketE;
                basketE = pos;
                basketS = pos - M + 1;
            }


        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
