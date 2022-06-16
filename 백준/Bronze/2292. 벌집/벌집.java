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

		int num = (N + 4) / 6;
		int sum = 0, cnt = 1;

		while (sum < num) {
			sum += cnt++;
		}

		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
}