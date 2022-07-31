import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		Map<Integer, ArrayList<String>> member = new HashMap<Integer, ArrayList<String>>();
		ArrayList<String> nameList;
		Set<Integer> ageSet = new TreeSet<Integer>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			ageSet.add(age);
			if (member.containsKey(age)) {
				nameList = member.get(age);
			} else {
				nameList = new ArrayList<>();
			}

			nameList.add(name);
			member.put(age, nameList);
		}

		Iterator<Integer> iterator = ageSet.iterator();
		while (iterator.hasNext()) {
			int age = iterator.next();
			nameList = member.get(age);

			for (String name : nameList) {
				bw.write(age + " " + name + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}