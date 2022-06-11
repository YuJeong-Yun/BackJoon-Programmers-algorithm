import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		String total = Integer.toString(A * B * C);
		int[] digitCnt = new int[10]; // 0-9 개수 담을 배열

		for (int i = 0; i < total.length(); i++) {
			int digit = total.charAt(i) - '0';
			digitCnt[digit]++;
		} // for

		for (int i = 0; i <= 9; i++) {
			System.out.println(digitCnt[i]);
		}

		br.close();
	}

}
