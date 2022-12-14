import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());
		int max = row > col ? row : col;
		int result = 1;
		int[][] square = new int[row][col];
		for (int i = 0; i < row; i++) {
			String str = br.readLine();
			for (int j = 0; j < col; j++) {
				square[i][j] = str.charAt(j) - '0';
			}
		}

		for (int k = 2; k <= max; k++) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (col >= j + k && row >= i + k) {
						int point = square[i][j];
						if (point == square[i][j + k - 1] && point == square[i + k - 1][j]
								&& point == square[i + k - 1][j + k - 1])
							result = k;
					}
				}
			}
		}

		bw.write(result * result + "");
		bw.flush();
		bw.close();
		br.close();

	}
}