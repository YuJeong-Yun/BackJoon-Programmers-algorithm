import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int limit = 4000;
		int[] nums = new int[N];
		int[] modeCnt = new int[limit * 2 + 1];

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			nums[i] = num;
			modeCnt[num + limit]++;
		}

		bw.write((int) Math.round(Arrays.stream(nums).average().orElse(0)) + "\n");

		Arrays.sort(nums);
		bw.write(nums[N / 2] + "\n");

		int mode = 0;
		int maxCnt = IntStream.of(modeCnt).max().getAsInt();
		List<Integer> modes = new ArrayList<>();
		for (int i = 0; i < limit * 2 + 1; i++) {
			if (modeCnt[i] == maxCnt) {
				modes.add(i - limit);
			}
		}
		if (modes.size() == 1) {
			mode = modes.get(0);
		} else {
			Collections.sort(modes);
			mode = modes.get(1);
		}
		bw.write(mode + "\n");

		int range = 0;
		if (N > 1) {
			range = nums[N - 1] - nums[0];
		}
		bw.write(range + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

}