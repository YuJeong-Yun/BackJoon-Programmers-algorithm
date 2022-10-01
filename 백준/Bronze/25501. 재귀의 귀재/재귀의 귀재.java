import java.io.*;
import java.util.*;

public class Main {
	static int cnt = 0;

	public static int recursion(String str, int l, int r) {
		cnt++;
		if (l >= r)
			return 1;
		else if (str.charAt(l) != str.charAt(r))
			return 0;
		else
			return recursion(str, l + 1, r - 1);
	}

	public static int isPalindrome(String str) {
		return recursion(str, 0, str.length() - 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			cnt = 0;

			bw.write(isPalindrome(br.readLine()) + " " + cnt + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}