import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		final int MAX = 10000;
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[MAX + 1];

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			nums[num]++;
		}

		for (int i = 1; i <= MAX; i++) {
			if (nums[i] != 0) {
				for (int j = 0; j < nums[i]; j++) {
					sb.append(i + "\n");
				}
			}
		}

		System.out.println(sb);
		br.close();
	}
}