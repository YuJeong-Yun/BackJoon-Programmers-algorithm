import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());

		int min = Math.min(num1, num2);
		int max = Math.max(num1, num2);
		int gcd = min;
		while (max % gcd != 0 || min % gcd != 0) {
			gcd--;
		}

		int lcm = max, seq = 2;
		while (lcm % min != 0) {
			lcm = max * seq++;
		}

		bw.write(gcd + "\n");
		bw.write(lcm + "");

		bw.flush();
		bw.close();
		br.close();
	}
}