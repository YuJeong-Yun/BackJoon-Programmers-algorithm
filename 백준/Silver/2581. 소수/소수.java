import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int min = N;
		int total = 0;
		for (int i = M; i <= N; i++) {
			boolean isPrime = true;

			if (i == 1)
				continue;

			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime == true) {
				total += i;
				if (i < min) {
					min = i;
				}
			}
		}

		if (total == 0) {
			bw.write("-1");
		} else {
			bw.write(total + "\n" + min);
		}

		bw.flush();
		bw.close();
		br.close();
	}
}