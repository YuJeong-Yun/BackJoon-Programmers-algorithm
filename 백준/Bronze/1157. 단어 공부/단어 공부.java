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

		int[] alphabets = new int[26];
		String word = br.readLine();

		for (int i = 0; i < word.length(); i++) {
			int alphabet = word.charAt(i);
			if(alphabet >='a' && alphabet <='z') {
				alphabets[alphabet-'a']++;
			} else {
				alphabets[alphabet-'A']++;
			}
		} // for

		int max = Arrays.stream(alphabets).max().getAsInt();
		int result = 0;
		for (int i = 0; i < alphabets.length; i++) {
			if (alphabets[i] == max) {
				if (result != 0) {
					result = '?';
				} else {
					result = i+'A';
				}
			} // if
		} // for

		bw.write((char)(result));
		bw.flush();
		bw.close();
		br.close();
	}
}