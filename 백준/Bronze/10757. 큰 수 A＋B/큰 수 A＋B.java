import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();

		String small = "", big = "";

		if (A.length() > B.length()) {
			big = A;
			small = B;
		} else {
			big = B;
			small = A;
		}

		int sum = 0;
		int over = 0;
		String result = "";
		for (int i = 1; i <= small.length(); i++) {
			sum = big.charAt(big.length() - i) + small.charAt(small.length() - i) - '0' * 2;
			if (over == 1) {
				sum++;
				over = 0;
			}
			if (sum >= 10) {
				over = 1;
			}
			result = sum % 10 + result;

		}

		if (A.length() != B.length()) {
			for (int i = 0; i < big.length() - small.length(); i++) {
				sum = big.charAt(big.length() - small.length() - 1 - i) - '0';
				if (over == 1) {
					sum++;
					over = 0;
				}
				if (sum >= 10) {
					over = 1;
				}
				result = sum % 10 + result;
			}
			if (over == 1) {
				result = 1 + result;
			}
		} else {
			if (over == 1) {
				result = 1 + result;
			}
		}

		bw.write(result);
		bw.flush();
		bw.close();
		br.close();
	}
}