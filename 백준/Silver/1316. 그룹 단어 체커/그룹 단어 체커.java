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
			int[] alphabets = new int[26];
			String s = br.readLine();

			int result = 1;
			for (int j = 0; j < s.length(); j++) {
				if (alphabets[s.charAt(j) - 'a'] == 1) {
					if (s.charAt(j-1) != s.charAt(j)) {
						result = 0;
						break;
					}
				}
				alphabets[s.charAt(j) - 'a'] = 1;
			}
			if (result == 1) {
				cnt++;
			}
		}

		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
		br.close();
	}
}