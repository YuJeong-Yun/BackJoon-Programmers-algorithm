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
		int[][] combi = new int[30][30];

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			combi[1][1] = combi[1][0] = 1;

			for (int k = 2; k <= n; k++) {
				for (int j = 0; j <= r && j <= k; j++) {
					if (j == 0) {
						combi[k][j] = 1;
					} else {
						combi[k][j] = combi[k - 1][j - 1] + combi[k - 1][j];
					}
				}
			}

			bw.write(combi[n][r] + "\n");

		}

		bw.flush();
		bw.close();
		br.close();
	}
}