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

		int N = Integer.parseInt(br.readLine());

		Set<Integer> numSet = new HashSet<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numSet.add(Integer.parseInt(st.nextToken()));
		}

		int M = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st2.nextToken());

			if (numSet.contains(num)) {
				bw.write(1 + " ");
			} else {
				bw.write(0 + " ");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}