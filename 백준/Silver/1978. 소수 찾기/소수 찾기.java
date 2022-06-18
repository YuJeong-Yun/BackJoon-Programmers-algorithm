import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int limit = 1000;
		int[] numArr = new int[limit + 1];

		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if (num % 2 != 0 || num == 2) {
				numArr[num] = 1;
			}
		}

		numArr[1] = 0;
		for (int i = 3, j = 1; i * ++j <= limit; i += 2) {
			while (i * ++j <= limit) {
				numArr[i * j] = 0;
			}
			j = 1;
		}

		int cnt = (int) Arrays.stream(numArr).filter(num -> num == 1).count();

		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
}