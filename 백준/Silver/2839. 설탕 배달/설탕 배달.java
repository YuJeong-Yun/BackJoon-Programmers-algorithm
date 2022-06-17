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

		if (N == 4 || N == 7) {
			bw.write("-1");
		} else if (N % 5 == 0) {
			bw.write(N / 5 + "");
		} else if ((N - 3) % 5 == 0) {
			bw.write((N - 3) / 5 + 1 + "");
		} else if ((N - 6) % 5 == 0) {
			bw.write((N - 6) / 5 + 2 + "");
		} else if ((N - 9) % 5 == 0) {
			bw.write((N - 9) / 5 + 3 + "");
		} else if ((N - 12) % 5 == 0) {
			bw.write((N - 12) / 5 + 4 + "");
		} else if (N % 3 == 0) {
			bw.write(N / 3 + "");
		} else {
			bw.write("-1");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}