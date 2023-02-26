import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int len = 64;
		int X = Integer.parseInt(br.readLine());

		int nlen = len, piece = len;
		int cnt = 1;
		while (nlen != X) {
			if (nlen - piece / 2 >= X) {
				piece /= 2;
				nlen -= piece;
			} else {
				piece /= 2;
				cnt++;
			}
		}

		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
}