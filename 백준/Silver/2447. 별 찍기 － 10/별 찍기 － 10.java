import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		char[][] stars = new char[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(stars[i], '*');
		}

		drawStar(n, stars, n);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(stars[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	public static void drawStar(int n, char[][] stars, int seq) {
		for (int z = 0; z < n / seq; z++) {
			for (int k = 0; k < n / seq; k++) {
				for (int j = seq / 3 + z * seq; j < seq / 3 + z * seq + seq / 3; j++) {
					for (int i = seq / 3 + k * seq; i < seq / 3 + k * seq + seq / 3; i++) {
						stars[j][i] = ' ';
					}
				}
			}
		}

		if (seq > 3) {
			drawStar(n, stars, seq / 3);
		}
	}


}