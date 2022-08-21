import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());

		N = N / 100 * 100;

		int result = N % F == 0 ? N : F * (N / F + 1);
		String resultS = result + "";
		String answer = resultS.charAt(resultS.length() - 2) + "" + resultS.charAt(resultS.length() - 1);

		bw.write(answer);

		bw.flush();
		bw.close();
		br.close();
	}
}