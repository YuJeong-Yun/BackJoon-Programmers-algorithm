import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String NS = br.readLine();
		int[] digit = new int[NS.length()];
		for (int i = 0; i < NS.length(); i++) {
			digit[i] = NS.charAt(i) - '0';
		}
		Arrays.sort(digit);
		for (int i = NS.length() - 1; i >= 0; i--) {
			bw.write(digit[i] + "");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}