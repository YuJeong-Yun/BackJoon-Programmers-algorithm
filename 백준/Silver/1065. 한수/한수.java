import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		if (N >= 100) {
			int cnt = 99;
			for (int j = 100; j <= N; j++) {
				if(j!=1000 && (j/100 - j%100/10) == (j%100/10 - j%10) ) {
					cnt ++;
				}
				
			} // for
			bw.write(cnt + "");

		} else {
			bw.write(N+"");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
