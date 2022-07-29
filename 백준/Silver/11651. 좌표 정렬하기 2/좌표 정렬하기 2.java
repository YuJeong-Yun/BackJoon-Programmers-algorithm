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
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Map<Integer, List<Integer>> point = new HashMap<>();

		List<Integer> xList;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (point.containsKey(y)) {
				xList = point.get(y);
				xList.add(x);
				point.put(y, xList);
			} else {
				xList = new ArrayList<>();
				xList.add(x);
				point.put(y, xList);
			}
		}

		Object[] yArr = point.keySet().toArray();
		Arrays.sort(yArr);
		for (Object yKey : yArr) {
			xList = point.get(yKey);
			Collections.sort(xList);
			for (int xValue : xList) {
				bw.write(xValue + " " + yKey + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}