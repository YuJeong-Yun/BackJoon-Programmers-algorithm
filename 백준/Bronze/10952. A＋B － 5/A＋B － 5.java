import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n1, n2;

		while (true) {
			n1 = sc.nextInt();
			n2 = sc.nextInt();

			if (n1 == 0 && n2 == 0)
				break;
			System.out.println(n1 + n2);
		}
	}
}
