import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int originalNum = num, cnt = 0;

		do {
			int sumNum = num / 10 + num % 10; // 각 자리수 더한 값
			num = num % 10 * 10 + sumNum % 10 ;
			cnt++;
		} while(num != originalNum);
		
		System.out.println(cnt);

	}
}