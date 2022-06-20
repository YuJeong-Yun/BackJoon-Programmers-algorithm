import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int result = 0;
		int temp = 1;
		int pre = 0;

		if (n == 1) {
			result = 1;
		}

		while (--n > 0) {
			result = temp + pre;
			pre = temp;
			temp = result;
		}

		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}
}