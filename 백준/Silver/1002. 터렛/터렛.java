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

		int N = Integer.parseInt(br.readLine());

		int[] p1 = new int[3];
		int[] p2 = new int[3];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 3; j++) {
				p1[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < 3; j++) {
				p2[j] = Integer.parseInt(st.nextToken());
			}

			double dist = Math.sqrt((Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2)));
			int[] max = p1[2] > p2[2] ? p1 : p2;
			int[] min = p1[2] < p2[2] ? p1 : p2;

			if (dist == 0) {
				if (p1[2] == p2[2]) {
					bw.write("-1\n");
				} else {
					bw.write("0\n");
				}
			} else {
				if (dist + min[2] < max[2]) {
					bw.write("0\n");
				} else if (dist + min[2] == max[2]) {
					bw.write("1\n");
				} else if (dist - min[2] == max[2]) {
					bw.write("1\n");
				} else if (dist > max[2] + min[2]) {
					bw.write("0\n");
				} else {
					bw.write("2\n");
				}
			}

		}

		bw.flush();
		bw.close();
		br.close();
	}
}