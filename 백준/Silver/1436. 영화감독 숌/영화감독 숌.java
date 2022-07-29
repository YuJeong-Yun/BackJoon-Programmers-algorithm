import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static boolean check(int num) {
		int chk = 0;

		while (num > 1 && chk != 3) {
			if (num % 10 == 6) {
				chk++;
			} else {
				chk = 0;
			}
			num /= 10;
		}

		if (chk == 3) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int seq = 0;
		int num = 666;

		while (seq != N) {
			if (check(num)) {
				seq++;
			}
			num++;
		}

		bw.write(num - 1 + "");

		bw.flush();
		bw.close();
		br.close();
	}
}