import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		Map<Integer, ArrayList<String>> wordMap = new HashMap<>();

		ArrayList<String> wordList;
		String word;
		int length;
		for (int i = 0; i < N; i++) {
			word = br.readLine();
			length = word.length();

			if (wordMap.containsKey(length)) {
				wordList = wordMap.get(length);
			} else {
				wordList = new ArrayList<>();
			}

			if (wordList.contains(word)) {
				continue;
			}
			wordList.add(word);
			wordMap.put(length, wordList);
		}

		Object[] lengths = wordMap.keySet().toArray();
		Arrays.sort(lengths);

		for (int i = 0; i < lengths.length; i++) {
			length = (int) lengths[i];

			wordList = wordMap.get(length);
			Collections.sort(wordList);

			for (int j = 0; j < wordList.size(); j++) {
				bw.write(wordList.get(j) + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}