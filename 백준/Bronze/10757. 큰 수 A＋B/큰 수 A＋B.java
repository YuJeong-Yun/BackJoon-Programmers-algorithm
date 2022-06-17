import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		String A = st.nextToken();
		String B = st.nextToken();

		int max = (A.length() > B.length()) ? A.length() : B.length();

		int[] aArr = new int[max];
		int[] bArr = new int[max];
		int[] sumArr = new int[max + 1];

		for (int i = 0; i < A.length(); i++) {
			aArr[i] = A.charAt(A.length() - i - 1) - '0';
		}

		for (int i = 0; i < B.length(); i++) {
			bArr[i] = B.charAt(B.length() - i - 1) - '0';
		}

		for (int i = 0; i < max; i++) {
			int sum = aArr[i] + bArr[i] + sumArr[i];
			sumArr[i] = sum % 10;
			sumArr[i + 1] = sum / 10;
		}

		if (sumArr[max] == 1) {
			sb.append(sumArr[max]);
		}
		for (int i = max - 1; i >= 0; i--) {
			sb.append(sumArr[i]);
		}

		System.out.println(sb);
		br.close();
	}
}