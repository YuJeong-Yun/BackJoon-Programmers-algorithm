import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int C = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();

			int N = st.countTokens(); // 학생의 수
			int[] scores = new int[N];
			int j = 0;
			while (st.hasMoreTokens()) {
				scores[j++] = Integer.parseInt(st.nextToken());
			}
			float avg = Arrays.stream(scores).sum() / N; // 전체 점수 평균
			float avgCnt = (float) Arrays.stream(scores).filter(score -> score > avg).count() / N * 100; // 평균 넘는 학생 수 백분율
			System.out.printf("%.3f%%\n",avgCnt);
		}

		br.close();
	}

}
