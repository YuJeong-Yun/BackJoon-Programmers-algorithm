import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		int total = nums[N-1] - nums[0];
		for (int i = 1; i < N; i++) {
			total += nums[i] - nums[i-1];
		}
		bw.write(total+"");

		bw.flush();
		bw.close();
		br.close();
	}

}