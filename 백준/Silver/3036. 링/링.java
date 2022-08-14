import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static String calcFraction(int n1, int n2) {
		ArrayList<Integer> divisor = new ArrayList<>();

		for (int i = 2; i <= n1; i++) {
			if (n1 % i == 0) {
				divisor.add(i);
			}
		}

		int gcf = divisor.size() - 1;
		while (gcf != -1) {
			if (n2 % divisor.get(gcf--) == 0) {
				gcf = divisor.get(++gcf);
				break;
			}
		}

		if (gcf == -1) {
			return n1 + "/" + n2;
		} else {

			return (n1 / gcf) + "/" + (n2 / gcf);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int first = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N - 1; i++) {
			int ring = Integer.parseInt(st.nextToken());

			bw.write(calcFraction(first, ring) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}