import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int MAX = 1000000;
		int N = Integer.parseInt(br.readLine());
		boolean[] nums = new boolean[MAX * 2 + 1];

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			nums[MAX + num] = true;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < MAX * 2 + 1; i++) {
			if (nums[i]) {
				sb.append(i - MAX + "\n");
			}
		}

		System.out.println(sb);
		br.close();
	}
}