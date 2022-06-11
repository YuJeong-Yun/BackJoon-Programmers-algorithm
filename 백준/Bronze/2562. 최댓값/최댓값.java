import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = 9;
		int[] nums = new int[cnt];

		int seq = 0, max = 0;

		for (int i = 0; i < cnt; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			if (nums[i] > max) {
				max = nums[i];
				seq = i;
			} // if
		} // for
		System.out.println(max);
		System.out.println(seq + 1);

	}

}
