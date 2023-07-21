import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        List<Integer> odd = new ArrayList<>(); // 홀수에서 리스트 개수 후보 2 3 _ 5 6 7 _ 9 ...
        List<Integer> even = new ArrayList<>(); // 짝수에서 리스트 개수 후보 3 4 5 _ 7 8 9 _ ...
        for (int i = 2; i <= 100; i++) {
            if (i % 4 != 0) {
                odd.add(i);
            }
            if ((i - 2) % 4 != 0) {
                even.add(i);
            }

        }

        List<Integer> tmpList = N % 2 == 0 ? even : odd;
        String answer = "";
        for (int i = 0; i < tmpList.size(); i++) {
            int len = tmpList.get(i); // 검토할 리스트 개수
            if (len < L) continue;

            int[] num = new int[len]; // 0부터  len-1까지 숫자 담을 배열
            int sum = 0;
            for (int j = 0; j < len; j++) {
                num[j] = j;
                sum += num[j];
            }

            int tmp= N-sum;
            if (tmp % len != 0) {
                continue;
            } else if (tmp < 0) {
                break;
            } else {
                for (int digit : num) {
                    answer += digit + tmp / len + " ";
                }
                break;
            }
        }

        if (answer.equals("")) {
            answer = "-1";
        }

        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }

}