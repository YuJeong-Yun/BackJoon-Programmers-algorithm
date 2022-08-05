import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int x1, y1, x2, y2;

	static int check(int cx, int cy, int cr) {
		double dist1 = Math.sqrt(Math.pow(cx - x1, 2) + Math.pow(cy - y1, 2));
		double dist2 = Math.sqrt(Math.pow(cx - x2, 2) + Math.pow(cy - y2, 2));

		if (dist1 < cr && dist2 < cr) {
			return 0;
		} else if (dist1 < cr && dist2 > cr) {
			return 1;
		} else if (dist1 > cr && dist2 < cr) {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			int N = Integer.parseInt(br.readLine());
			int total = 0;

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				total += check(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			bw.write(total + "\n");

		}

		bw.flush();
		bw.close();
		br.close();
	}
}