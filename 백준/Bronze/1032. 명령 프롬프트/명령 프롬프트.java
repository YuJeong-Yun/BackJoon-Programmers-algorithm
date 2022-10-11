import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String[] result = new String[str.length()];
		for (int i = 0; i < N - 1; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j) != tmp.charAt(j)) {
					result[j] = "?";
				}
			}
		}
		for(int i=0; i<str.length(); i++) {
			if(result[i] == null) {
				result[i] = str.charAt(i)+"";
			}
		}
		for(int i=0; i<str.length(); i++) {
			bw.write(result[i]);
		}
		bw.flush();
		bw.close();
		br.close();
	}

}