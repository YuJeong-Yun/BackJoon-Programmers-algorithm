import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int cnt = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			for (int j = 0; j < s.length(); j++) {
				for (int k = 0; k < cnt; k++) {
					sb.append(s.charAt(j));
				} // for
			} // for
			System.out.println(sb);
		} // for
		br.close();
	}
}