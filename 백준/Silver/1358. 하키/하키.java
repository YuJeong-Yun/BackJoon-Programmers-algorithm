import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int W, H, X, Y, R;

	public static int checkPlayer(int x, int y) {
		if (x >= X && x <= X + W && y >= Y && y <= Y + H) {
			return 1;
		} else if (x < X && Math.pow(X - x, 2) + Math.pow(y - Y - R, 2) <= R * R) {
			return 1;
		} else if (Math.pow(x - X - W, 2) + Math.pow(y - Y - R, 2) <= R * R) {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		R = H / 2;
		int P = Integer.parseInt(st.nextToken());

		int total = 0;
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			total += checkPlayer(x, y);
		}

		bw.write(total + "");

		bw.flush();
		bw.close();
		br.close();
	}
}