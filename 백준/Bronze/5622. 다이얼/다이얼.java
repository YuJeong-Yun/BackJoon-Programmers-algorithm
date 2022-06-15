import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		int total = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c <= 'C') {
				total += 3;
			} else if (c <= 'F') {
				total += 4;
			} else if (c <= 'I') {
				total += 5;
			} else if (c <= 'L') {
				total += 6;
			} else if (c <= 'O') {
				total += 7;
			} else if (c <= 'S') {
				total += 8;
			} else if (c <= 'V') {
				total += 9;
			} else {
				total += 10;
			}
		}

		bw.write(total+"");
		bw.flush();
		bw.close();
		br.close();
	}
}