public class Main {
	static int[] nums = new int[10001];

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer();

		for (int i = 1; i < 10000; i++) {
			d(i);
		} // for

		for (int i = 1; i <= 10000; i++) {
			if (nums[i] == 0) {
				sb.append(i + "\n");
			}
		}
		System.out.println(sb);
	}

	public static void d(int num) {
		String numS = Integer.toString(num);
		int newNum = num;

		for (int i = 0; i < numS.length(); i++) {
			int digit = numS.charAt(i) - '0';
			newNum += digit;
		}

		if (newNum <= 10000) {
			nums[newNum] = 1;
		}
	}
}
