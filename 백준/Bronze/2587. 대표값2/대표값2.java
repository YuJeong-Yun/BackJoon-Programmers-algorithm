import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int total = 0, cnt = 5;
		int[] nums = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			int num = Integer.parseInt(br.readLine());
			total += num;
			nums[i] = num;
		}
		Arrays.sort(nums);

		bw.write(total / cnt + "\n" + nums[cnt / 2]);
		bw.flush();
		bw.close();
		br.close();
	}

}