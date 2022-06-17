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

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());

			String roomNum = (N % H == 0) ? (H) + "" : (N % H) + "";
			roomNum += String.format("%02d", (N % H == 0) ? (N / H) : (N / H) + 1);

			bw.write(roomNum + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}