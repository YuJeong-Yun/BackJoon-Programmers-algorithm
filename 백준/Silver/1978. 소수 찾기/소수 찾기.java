import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int limit = 1000, cnt = 0;
		boolean[] isNotPrime = new boolean[limit + 1];

		for (int i = 2; i <= Math.sqrt(limit); i++) {
			if (!isNotPrime[i]) {
				for (int j = i * i; j <= limit; j += i) {
					isNotPrime[j] = true;
				}
			}
		}

		isNotPrime[0] = isNotPrime[1] = true;
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if (!isNotPrime[num]) {
				cnt++;
			}

		}

		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
}