

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] digit = new int[10];
        String num = br.readLine();

        for (char c : num.toCharArray()) {
            digit[c - '0']++;
        }
        int answer = (int) Math.ceil((digit[6] + digit[9]) / 2.0);
        digit[6] = digit[9] = 0;

        for (int i : digit) {
            answer = Math.max(i, answer);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
