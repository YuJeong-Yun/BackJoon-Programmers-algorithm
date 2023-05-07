import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int gcdVal = arr[1] - arr[0];
        for (int i = 2; i < N; i++) {
            gcdVal = gcd(gcdVal, arr[i] - arr[0]);
        }

        TreeSet<Integer> div = new TreeSet<>();
        for (int i = 2; i <= Math.sqrt(gcdVal); i++) {
            if (gcdVal % i == 0) {
                div.add(i);
                div.add(gcdVal / i);
            }
        }

        for (int i : div) {
            bw.write(i + " ");
        }
        bw.write(gcdVal + "");


        bw.flush();
        bw.close();

    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}