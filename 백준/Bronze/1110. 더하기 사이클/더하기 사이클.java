import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int nowNum = num, cnt = 0;

		do {
			int sumNum = num / 10 + num % 10; // 각 자리수 더한 값
			String afterNumS = Integer.toString(num % 10) + Integer.toString(sumNum % 10);
			num = Integer.parseInt(afterNumS);
			cnt++;
		} while(num != nowNum);
		
		System.out.println(cnt);

	}
}
