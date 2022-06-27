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

		int start = 666;
		int seq = 0;
		while (true) {
			String startS = String.valueOf(start);
			if (startS.contains("666")) {
				seq++;
			}
			if (seq == N) {
				break;
			}

			start++;
		}

		bw.write(start + "");
		bw.flush();
		bw.close();
		br.close();

	}
}