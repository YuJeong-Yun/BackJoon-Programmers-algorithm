import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int length = Integer.toString(N).length();

		int start = N - 9 * length;

		int result = 0;
		for (int i = start; i < N; i++) {
			int sum = i;
			for (int j = 0; j < Integer.toString(i).length(); j++) {
				sum += Integer.toString(i).charAt(j) - '0';
			}

			if (sum == N) {
				result = i;
				break;
			}
		}

		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}
}