import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int result = calcFibonacci(n);

		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int calcFibonacci(int n) {

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		return calcFibonacci(n - 1) + calcFibonacci(n - 2);
	}
}