import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Map<Integer, List<Integer>> coordinate = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			List<Integer> list = null;
			if (coordinate.get(x) == null) {
				list = new ArrayList<>();

				list.add(y);
				coordinate.put(x, list);
			} else {
				list = coordinate.get(x);
				list.add(y);
				coordinate.put(x, list);
			}
		}

		List<Integer> keySet = new ArrayList<>(coordinate.keySet());
		Collections.sort(keySet);
		
		for (int key : keySet) {
			List<Integer> list = coordinate.get(key);

			Collections.sort(list);

			for (int value : list) {
				bw.write(key + " " + value + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}