import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] point = new int[N];
		int[] pointSort = new int[N];
		Map<Integer, Integer> pointMap = new HashMap<Integer, Integer>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			point[i] = num;
			pointSort[i] = num;
		}

		Arrays.sort(pointSort);

		int seq = 0;
		pointMap.put(pointSort[0], seq++);
		for (int i = 1; i < N; i++) {
			if (pointSort[i] != pointSort[i - 1]) {
				pointMap.put(pointSort[i], seq++);
			}
		}

		for (int i = 0; i < N; i++) {
			bw.write(pointMap.get(point[i]) + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}