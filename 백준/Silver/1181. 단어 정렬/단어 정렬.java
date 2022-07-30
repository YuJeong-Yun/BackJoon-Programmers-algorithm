import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		List<String> wordList = new ArrayList<>();

		String word = br.readLine();
		wordList.add(word);

		out:for (int i = 0; i < N - 1; i++) {
			word = br.readLine();

			int size = wordList.size();
			for (int j = 0; j < size; j++) {
				String getWord = wordList.get(j);

				if (word.length() < getWord.length()) {
					wordList.add(j, word);
					continue out;
				}else if(word.length() == getWord.length()) {
					if(word.compareTo(getWord) < 0) {
						wordList.add(j, word);
						continue out;
					}else if(word.equals(getWord)) {
						continue out;
					}
				}
			}

			wordList.add(word);
		}

		for (int i = 0; i < wordList.size(); i++) {
			bw.write(wordList.get(i) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}