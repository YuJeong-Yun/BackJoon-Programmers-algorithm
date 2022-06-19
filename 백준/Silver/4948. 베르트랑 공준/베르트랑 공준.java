import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		do {
			int cnt = 0;
			for (int i = N + 1; i <= 2 * N; i++) {
				boolean isPrime = true;

				if (i == 1) {
					continue;
				}
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						isPrime = false;
						break;
					}
				}
				if (isPrime == true) {
					cnt++;
				}
			}
			sb.append(cnt + "\n");

			N = Integer.parseInt(br.readLine());
		} while (N != 0);

		System.out.println(sb);
		br.close();
	}
}