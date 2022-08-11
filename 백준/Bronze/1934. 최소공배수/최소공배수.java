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

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int num1, num2, max, min, lcm, seq;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());

			max = Math.max(num1, num2);
			min = Math.min(num1, num2);
			lcm = max;

			seq = 2;
			while (lcm % min != 0) {
				lcm = max * seq++;
			}
			bw.write(lcm + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}