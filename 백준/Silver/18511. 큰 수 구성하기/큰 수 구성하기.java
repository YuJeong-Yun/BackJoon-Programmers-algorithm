import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String strN = st.nextToken();
        int N = Integer.parseInt(strN);
        int kLen = Integer.parseInt(st.nextToken());

        Character[] K = new Character[kLen];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < kLen; i++) {
            K[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(K, Collections.reverseOrder());


        int answer = Integer.parseInt((K[0] + "").repeat(strN.length())), i = strN.length() - 1, p = 1;
        char[] cAnswer = (answer + "").toCharArray();
        if (kLen > 1) {
            while (answer > N) {
                if (p == kLen) {
                    cAnswer[i--] = K[0];
                    p = 1;
                }
                if (i == -1) {
                    break;
                }
                cAnswer[i] = K[p++];
                answer = Integer.parseInt(String.valueOf(cAnswer));
            }
        }
        if (answer > N) {
            cAnswer[0] = '0';
            answer = Integer.parseInt(String.valueOf(cAnswer));
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
