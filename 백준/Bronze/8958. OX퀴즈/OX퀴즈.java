import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), "X");
			
			int totalScore = 0;
			while (st.hasMoreTokens()) {
				int score = st.nextToken().length();
				totalScore += (score+1)*(score)/2; // n까지의 합 공식 : (n+1)*n/2
			} // while
			System.out.println(totalScore);
		} // for

	}
}