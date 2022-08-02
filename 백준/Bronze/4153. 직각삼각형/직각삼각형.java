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

		int[] tri = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (true) {
			tri[0] = Integer.parseInt(st.nextToken());
			tri[1] = Integer.parseInt(st.nextToken());
			tri[2] = Integer.parseInt(st.nextToken());

			if (tri[0] == 0 && tri[1] == 0 && tri[2] == 0) {
				break;
			}

			Arrays.sort(tri);
			if (tri[2] * tri[2] == tri[0] * tri[0] + tri[1] * tri[1]) {
				bw.write("right\n");
			} else {
				bw.write("wrong\n");
			}

			st = new StringTokenizer(br.readLine());
		}

		bw.flush();
		bw.close();
		br.close();
	}
}