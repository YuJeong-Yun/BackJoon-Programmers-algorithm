import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int hour = sc.nextInt();
		int minute = sc.nextInt();
		int takeTime = sc.nextInt();

		int totalMinute = minute + takeTime;

		int afterHour = hour + (totalMinute / 60), afterMinute = totalMinute;

		if (hour + (totalMinute / 60) >= 24) {
			afterHour = afterHour - 24;
		}
		if (afterMinute >= 60) {
			afterMinute %= 60;
		}

		System.out.println(afterHour + " " + afterMinute);
	}
}
