import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();

		boolean[] isPrime = new boolean[N + 1];

		Arrays.fill(isPrime, true);
		isPrime[1] = false;

		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (isPrime[i] == true) {
				for (int j = i * i; j <= N; j += i) {
					isPrime[j] = false;
				}
			}
		}

		for (int i = M; i <= N; i++) {
			if (isPrime[i] == true) {
				sb.append(i + "\n");
			}
		}

		System.out.println(sb);
		br.close();
	}
}