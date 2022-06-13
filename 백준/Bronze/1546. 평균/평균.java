import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = sc.nextInt();
		int[] scores = new int[cnt];
		double totalScore = 0;

		for (int i = 0; i < cnt; i++) {
			int score = sc.nextInt();
			scores[i] = score;
			totalScore += score;
		}

		int max = IntStream.of(scores).max().orElse(0); // 최대값 구하기

		double avg = totalScore / max * 100 / cnt; // 평균값
		System.out.println(avg);
	}
}