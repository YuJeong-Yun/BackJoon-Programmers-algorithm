import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int r = Integer.parseInt(br.readLine());

		bw.write(String.format("%.6f", Math.PI * r * r) + "\n");
		bw.write(String.format("%.6f", 2.0 * r * r) + "");

		bw.flush();
		bw.close();
		br.close();
	}
}