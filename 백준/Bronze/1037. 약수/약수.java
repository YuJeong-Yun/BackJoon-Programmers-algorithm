import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] divisor = new int[cnt];

		for (int i = 0; i < cnt; i++) {
			divisor[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(divisor);

		int result = 0;
		if (cnt % 2 == 1) {
			result = (int) Math.pow(divisor[cnt / 2], 2);
		} else {
			result = divisor[0] * divisor[cnt - 1];
		}
		bw.write(result + "");

		bw.flush();
		bw.close();
		br.close();
	}
}