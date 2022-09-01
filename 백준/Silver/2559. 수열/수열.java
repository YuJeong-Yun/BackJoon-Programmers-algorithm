import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] temp = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for (int i = 0; i < K; i++) {
			max += temp[i];
		}
		for (int i = 1; i < N - K + 1; i++) {
			int sum = 0;
			for (int j = i; j < i + K; j++) {
				sum += temp[j];
			}
			max = max > sum ? max : sum;
		}

		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
