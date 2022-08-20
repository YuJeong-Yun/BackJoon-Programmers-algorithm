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

		int cnt10 = 0, cnt2 = 0, cnt5 = 0, temp = 0;

		for (int i = 1; i <= N; i++) {
			temp = i;
			while (temp % 10 == 0) {
				temp /= 10;
				cnt10++;
			}
			while (temp % 5 == 0) {
				temp /= 5;
				cnt5++;
			}
			while (temp % 2 == 0) {
				temp /= 2;
				cnt2++;
			}
		}
		int min = Math.min(cnt2, cnt5);

		bw.write(cnt10 + min + "");

		bw.flush();
		bw.close();
		br.close();
	}
}