import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String word = br.readLine();
		int answer = 1, len = word.length();
		for (int i = 0; i < len / 2; i++) {
			if (word.charAt(i) != word.charAt(len - 1 - i)) {
				answer = 0;
				break;
			}
		}

		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();

	}

}