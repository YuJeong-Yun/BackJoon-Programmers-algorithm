import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			if (N == 1) {
				sb.append("1\n");
			} else {
				sb.append(calcPrime(N) + "\n");
			}
		}

		System.out.println(sb);
		br.close();
	}

	public static int calcPrime(int N) {
		int cnt = 0;
		boolean[] isPrime = new boolean[2 * N + 1];
		Arrays.fill(isPrime, true);

		for (int i = 2; i <= Math.sqrt(2 * N); i++) {
			if (isPrime[i] == true) {
				for (int j = i * i; j < isPrime.length; j += i) {
					isPrime[j] = false;
				}
			}
		}

		for (int i = N + 1; i <= 2 * N; i++) {
			if (isPrime[i] == true)
				cnt++;
		}
		return cnt;
	}
}