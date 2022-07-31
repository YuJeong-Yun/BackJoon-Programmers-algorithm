import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> strSet = new HashSet<>();

		for (int i = 0; i < N; i++) {
			strSet.add(br.readLine());
		}

		int total = 0;
		for (int i = 0; i < M; i++) {
			if (strSet.contains(br.readLine())) {
				total++;
			}
		}

		bw.write(total + "");

		bw.flush();
		bw.close();
		br.close();
	}
}