import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int sum = 1, cnt = 1;
		while (sum < N) {
			sum = ++cnt * (cnt+1) / 2;
		}

		if (cnt % 2 == 0) {
			System.out.println(cnt - (sum - N) + "/" + (1 + (sum - N)));
		} else {
			System.out.println(1 + (sum - N) + "/" + (cnt - (sum - N)));
		}

		br.close();
	}
}