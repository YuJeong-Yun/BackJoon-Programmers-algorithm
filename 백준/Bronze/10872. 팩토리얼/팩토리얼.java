import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int result;
		if (N == 0 || N == 1) {
			result = 1;
		} else {
			result = N;
		}

		while (N > 1) {
			result *= (--N);
		}

		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}
}