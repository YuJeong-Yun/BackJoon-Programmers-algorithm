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

		if (N >= 100) {
			int cnt = 99;
			for (int j = 100; j <= N; j++) {
				int result = 0;

				String NS = Integer.toString(j);
				
				int sub = NS.charAt(0) - NS.charAt(1);
				for (int i = 1; i < NS.length() - 1; i++) {
					if ((NS.charAt(i) - NS.charAt(i + 1)) != sub) {
						result = 1;
					} // if
				} // for
				if (result == 0) {
					cnt++;
				}
			} // for
			bw.write(cnt + "");

		} else {
			bw.write(N+"");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}