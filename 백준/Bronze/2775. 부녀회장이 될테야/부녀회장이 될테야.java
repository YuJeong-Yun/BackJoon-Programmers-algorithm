import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			int[][] apartment = new int[k + 1][n];

			for (int j = 0; j < n; j++) {
				apartment[0][j] = j+1;
			}

			for (int floor = 1; floor <= k; floor++) {
				for (int roomNum = 1; roomNum <= n; roomNum++) {
					for (int z = 1; z <= roomNum; z++) {
						apartment[floor][roomNum-1] += apartment[floor-1][z-1];
					}
				}
			}
			bw.write(apartment[k][n-1]+"\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}