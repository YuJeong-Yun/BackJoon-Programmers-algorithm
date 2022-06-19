import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());

			boolean[] isPrime = new boolean[n + 1];
			Arrays.fill(isPrime, true);

			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (isPrime[i] == true) {
					for (int j = i * i; j <= n; j += i) {
						isPrime[j] = false;
					}
				}
			}

			if (isPrime[n / 2]) {
				sb.append(n / 2 + " " + n / 2 + "\n");
			} else {
				for (int i = n / 2 - 1, j = n / 2 + 1; i > 1; i--, j++) {
					if (isPrime[i] && isPrime[j]) {
						sb.append(i + " " + j + "\n");
						break;
					}
				}
			}
		}
		System.out.println(sb);
		br.close();
	}
}