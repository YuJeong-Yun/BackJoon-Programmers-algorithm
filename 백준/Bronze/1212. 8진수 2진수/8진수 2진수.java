import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		String[] arr = { "000", "001", "010", "011", "100", "101", "110", "111" };

		for (int i = 0; i < s.length(); i++) {
			int num = s.charAt(i) - '0';
			sb.append(arr[num]);
		}

		String answer = sb.toString();
		while (answer.length() > 1 && answer.charAt(0) == '0') {
			answer = answer.substring(1);
		}

		bw.write(answer);
		bw.flush();
		bw.close();
		br.close();
	}
}