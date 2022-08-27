import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st2.nextToken());
		int C = Integer.parseInt(st2.nextToken());

		long total = 0, temp = 0;
		for (int i = 0; i < N; i++) {
			int student = Integer.parseInt(st.nextToken());
			if (student - B < 0) {
				temp = 0;
			} else if ((student - B) % C > 0) {
				temp = (student - B) / C + 1;
			} else {
				temp = (student - B) / C;
			}
			total += (temp + 1);
		}

		bw.write(total + "");
		bw.flush();
		bw.close();
		br.close();
	}
}