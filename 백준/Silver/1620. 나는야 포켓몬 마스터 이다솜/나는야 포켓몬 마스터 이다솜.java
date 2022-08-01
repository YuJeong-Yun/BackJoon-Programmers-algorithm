import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, String> pocketmonName = new HashMap<>();
		Map<String, String> pocketmonNum = new HashMap<>();
		String pocketmon;
		for (int i = 0; i < N; i++) {
			pocketmon = br.readLine();
			pocketmonName.put(pocketmon, i + 1 + "");
			pocketmonNum.put(i + 1 + "", pocketmon);
		}

		for (int i = 0; i < M; i++) {
			String val = br.readLine();
			if (val.charAt(0) < 65) {
				bw.write(pocketmonNum.get(val) + "\n");
			} else {
				bw.write(pocketmonName.get(val) + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}