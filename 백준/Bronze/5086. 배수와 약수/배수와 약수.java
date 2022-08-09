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

		StringTokenizer st;

		int num1, num2;
		while (true) {
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());

			if (num1 == 0 && num2 == 0) {
				break;
			}

			if (num1 > num2) {
				if ((double) (num1 / num2) == (double) num1 / num2) {
					bw.write("multiple\n");
				} else {
					bw.write("neither\n");
				}
			} else {
				if ((double) (num2 / num1) == (double) num2 / num1) {
					bw.write("factor\n");
				} else {
					bw.write("neither\n");
				}
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}