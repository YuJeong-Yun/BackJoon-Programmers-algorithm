import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = 8;
		int result=0;
		for (int i = 0; i < size; i++) {
			String str= br.readLine();
			if (i % 2 == 0) {
				for (int j = 0; j < size; j+=2) {
					if(str.charAt(j) == 'F') {
						result++;
					}
				}
			} else {
				for (int j = 1; j < size; j+=2) {
					if(str.charAt(j) == 'F') {
						result++;
					}
				}
			}
		}

		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}

}