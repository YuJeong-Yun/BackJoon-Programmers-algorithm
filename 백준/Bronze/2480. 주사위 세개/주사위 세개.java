import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int reward = 0;

		if (a == b && a == c) { // 같은 눈 3개
			reward = 10000 + a * 1000;
		} else if (a == b || a == c) {
			reward = 1000 + a * 100;
		} else if (b == c) {
			reward = 1000 + b * 100;
		} else {
			int big = (a > b ? (c > a ? c : a) : (b > c ? b : c));
			reward = big * 100;
		}
		
		System.out.println(reward);
	}
}
