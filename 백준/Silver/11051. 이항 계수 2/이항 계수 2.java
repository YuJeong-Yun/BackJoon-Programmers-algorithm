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

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] combi = new int[N + 1][K + 2];
		combi[0][0] = combi[1][1] = combi[1][0] = 1;

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= K && j <= i; j++) {
				if (j == 0) {
					combi[i][j] = 1;
				} else {
					combi[i][j] = (combi[i - 1][j - 1] + combi[i - 1][j]) % 10007;
				}
			}
		}

		bw.write(combi[N][K] + "");

		bw.flush();
		bw.close();
		br.close();
	}
}