import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> nameSet = new HashSet<>();
		String name;
		for (int i = 0; i < N; i++) {
			name = br.readLine();
			nameSet.add(name);
		}

		ArrayList<String> nameList = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			name = br.readLine();
			if (nameSet.contains(name)) {
				nameList.add(name);
			}
		}

		Collections.sort(nameList);

		bw.write(nameList.size() + "\n");
		for (int i = 0; i < nameList.size(); i++) {
			bw.write(nameList.get(i) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}