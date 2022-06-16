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

		int i = 1, cnt = 1;
		while (i < N) {
			i += ++cnt;
		}

		if (cnt % 2 == 0) {
			bw.write(cnt - (i - N) + "/" + (1 + (i - N)));
		} else {
			bw.write(1 + (i - N) + "/" + (cnt - (i - N)));
		}

		bw.flush();
		bw.close();
		br.close();
	}
}