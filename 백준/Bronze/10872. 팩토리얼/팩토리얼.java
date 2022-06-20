import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int result = N;
		while (N != 1) {
			if (N == 0) {
				result = 1;
				break;
			}

			result *= (--N);
		}

		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}
}