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

		String[][] chess = new String[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				chess[i][j] = "" + s.charAt(j);
			}
		}

		String[] ex1 = new String[M], ex2 = new String[M];
		for (int i = 0; i < M; i += 2) {
			ex1[i] = "B";
			ex2[i] = "W";
		}
		for (int i = 1; i < M; i += 2) {
			ex1[i] = "W";
			ex2[i] = "B";
		}

		for (int i = 0; i < N; i += 2) {
			for (int j = 0; j < M; j++) {
				if (chess[i][j].equals(ex1[j])) {
					chess[i][j] = "";
				}
			}
		}
		for (int i = 1; i < N; i += 2) {
			for (int j = 0; j < M; j++) {
				if (chess[i][j].equals(ex2[j])) {
					chess[i][j] = "";
				}
			}
		}

		int result = 64, temp = 0;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				temp = 0;
				for (int k = i; k < i + 8; k++) {
					for (int z = j; z < j + 8; z++) {
						if (chess[k][z] == "") {
							temp++;
						}
					}
				}
				temp = Math.min(temp, 64 - temp);
				result = Math.min(result, temp);

			}
		}

		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}
}