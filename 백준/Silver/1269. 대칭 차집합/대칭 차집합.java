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

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[] set = new boolean[100000001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			set[Integer.parseInt(st.nextToken())] = true;
		}

		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			if (set[Integer.parseInt(st.nextToken())]) {
				cnt++;
			}
		}

		bw.write(N + M - 2 * cnt + "");

		bw.flush();
		bw.close();
		br.close();
	}
}