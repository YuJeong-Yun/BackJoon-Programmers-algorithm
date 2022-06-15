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
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();

			int result = 0;
			for (int j = 0; j < s.length() - 1; j++) {
				if (s.charAt(j) == s.charAt(j + 1)) {
					s = s.replaceAll(s.charAt(j) + "" + s.charAt(j), s.charAt(j) + "");
					j--;
				}
			}

			for (int j = 0; j < s.length(); j++) {
				if (s.indexOf(s.charAt(j)) != s.lastIndexOf(s.charAt(j))) {
					result = 1;
					break;
				}
			} // for
			if (result == 0) {
				cnt++;
			}
		} // for

		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
		br.close();
	}
}