

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int n1 = n / 2;
            int n2 = n / 2;
            while (n1 > 1) {
                if (isPrimeNum(n1) && isPrimeNum(n2)) {
                    bw.write(n1 + " " + n2 + "\n");
                    break;
                }
                n1--;
                n2++;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isPrimeNum(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
