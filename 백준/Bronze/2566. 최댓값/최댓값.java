import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int len = 9;
		int max = -1, row = 0, col = 0;
		for (int i = 0; i < len; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < len; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num > max) {
					max = num;
					row = i + 1;
					col = j + 1;
				}
			}
		}

		bw.write(max+"\n"+row+" "+col);
		bw.flush();
		bw.close();
		br.close();
	}

}