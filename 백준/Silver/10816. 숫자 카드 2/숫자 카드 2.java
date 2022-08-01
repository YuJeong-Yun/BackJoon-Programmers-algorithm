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
		int[] num = new int[20000001];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[Integer.parseInt(st.nextToken()) + 10000000]++;
		}

		int M = Integer.parseInt(br.readLine());

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			bw.write(num[Integer.parseInt(st2.nextToken()) + 10000000] + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}