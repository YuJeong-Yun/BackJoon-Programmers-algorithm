import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		String[] wordArr = new String[N];

		for (int i = 0; i < N; i++) {
			wordArr[i] = br.readLine();
		}

		Arrays.sort(wordArr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else if (o1.length() > o2.length()) {
					return 1;
				} else {
					return -1;
				}
			}
		});

		String word;
		sb.append(wordArr[0] + "\n");
		for (int i = 1; i < N; i++) {
			word = wordArr[i];
			if (!wordArr[i].equals(wordArr[i - 1])) {
				sb.append(wordArr[i] + "\n");
			}
		}

		System.out.println(sb);
		br.close();
	}
}