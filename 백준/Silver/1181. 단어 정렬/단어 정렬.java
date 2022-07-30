import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		Set<String> wordSet = new HashSet<>();

		for (int i = 0; i < N; i++) {
			wordSet.add(br.readLine());
		}

		ArrayList<String> wordList;
		for (int i = 1; i <= 50; i++) {
			Iterator<String> iterator = wordSet.iterator();
			wordList = new ArrayList<>();

			while (iterator.hasNext()) {
				String word = iterator.next();
				if (word.length() == i) {
					wordList.add(word);
				}
			}
			wordSet.removeAll(wordList);
			
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