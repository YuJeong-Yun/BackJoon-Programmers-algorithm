import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int n1, n2;

		for (int i = 1; i <= num; i++) {
			n1 = sc.nextInt();
			n2 = sc.nextInt();

			System.out.println("Case #" + i + ": " + n1 + " + " + n2 + " = " + (n1 + n2));
		}
	}
}
