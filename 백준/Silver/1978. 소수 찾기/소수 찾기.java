import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int cnt = 0;
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			boolean primeNum = true;

			if (num == 1) {
				continue;
			}

			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) {
					primeNum = false;
					break;
				}
			}
			if (primeNum == true) {
				cnt++;
			}

		}

		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
}