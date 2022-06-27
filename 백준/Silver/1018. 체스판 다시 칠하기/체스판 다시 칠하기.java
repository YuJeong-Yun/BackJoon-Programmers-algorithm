import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static boolean[][] chess;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		chess = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				chess[i][j] = s.charAt(j) == 'B' ? true : false;
			}
		}

		int result = 64, temp = 0, length = 8;
		for (int i = 0; i <= N - length; i++) {
			for (int j = 0; j <= M - length; j++) {
				temp = chessBoard(i, j, length);
				result = Math.min(result, temp);
			}
		}

		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int chessBoard(int x, int y, int length) {
		boolean BW = true;

		int temp = 0;
		for (int i = x; i < x + length; i++) {
			for (int j = y; j < y + length; j++) {
				if (chess[i][j] != BW) {
					temp++;
				}
				BW = !BW;
			}
			BW = !BW;
		}
		temp = Math.min(temp, 64 - temp);
		return temp;
	}
}