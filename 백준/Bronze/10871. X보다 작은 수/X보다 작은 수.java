import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = sc.nextInt();
		int A = sc.nextInt();
		
		
		for(int i=0; i<cnt;i++) {
			int num = sc.nextInt();
			if(num < A) {
				System.out.print(num+" ");
			}
		} // for
		
	}
}
