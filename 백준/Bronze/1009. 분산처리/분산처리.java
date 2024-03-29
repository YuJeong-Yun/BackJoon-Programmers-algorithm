import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int num = a;
			for (int j = 1; j < b; j++) {
				num %= 100;
				num *= a;
			}
			int result = num % 10 == 0 ? 10 : num % 10;
			bw.write(result+"\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}