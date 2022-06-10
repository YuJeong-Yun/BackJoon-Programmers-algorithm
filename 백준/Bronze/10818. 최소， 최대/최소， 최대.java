import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = sc.nextInt();
		int[] nums = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			nums[i] = sc.nextInt();
		}

		if (cnt == 1) {
			System.out.println(nums[0] + " " + nums[0]);
			return;
		}
		int min = nums[0], max = nums[0];
		for (int i = 1; i < cnt; i++) {
			if (nums[i] < min) min = nums[i];
			if (nums[i] > max) max = nums[i];
		}
		System.out.println(min + " " + max);
	}
}
