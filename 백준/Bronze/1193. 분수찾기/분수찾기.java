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

		int sum = 1, cnt = 1;
		while (sum < N) {
			sum = ++cnt * (cnt+1) / 2;
		}

		if (cnt % 2 == 0) {
			bw.write(cnt - (sum - N) + "/" + (1 + (sum - N)));
		} else {
			bw.write(1 + (sum - N) + "/" + (cnt - (sum - N)));
		}

		bw.flush();
		bw.close();
		br.close();
	}
}