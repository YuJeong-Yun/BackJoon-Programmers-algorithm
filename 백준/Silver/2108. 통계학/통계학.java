import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int limit = 4000;
		int[] nums = new int[N];
		int[] modeCnt = new int[limit * 2 + 1];

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			nums[i] = num;
			modeCnt[num + limit]++;
		}

		sb.append(calcMean(nums) + "\n");

		sb.append(calcMedian(nums, N) + "\n");

		sb.append(calcMode(modeCnt, N, limit) + "\n");

		sb.append(calcRange(nums, N) + "\n");

		System.out.println(sb);
		br.close();
	}

	public static int calcMean(int[] nums) {
		return (int) Math.round(Arrays.stream(nums).average().orElse(0));
	}

	public static int calcMedian(int[] nums, int N) {
		Arrays.sort(nums);
		return nums[N / 2];
	}

	public static int calcMode(int[] modeCnt, int N, int limit) {
		int mode = 0;
		int maxCnt = IntStream.of(modeCnt).max().orElse(0);
		
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

		return mode;
	}

	public static int calcRange(int[] nums, int N) {
		int range = 0;

		if (N > 1) {
			Arrays.sort(nums);
			range = nums[N - 1] - nums[0];
		}
		return range;
	}
}