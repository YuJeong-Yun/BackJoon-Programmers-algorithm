import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = 1000;
		int L = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] check = new boolean[size + 1];
		int min = size, max = 0;
		for (int i = 0; i < L; i++) {
			int num = Integer.parseInt(st.nextToken());
			check[num] = true;
			min = min < num ? min : num;
			max = max > num ? max : num;
		}
		int n = Integer.parseInt(br.readLine());

		int result = 0;
		int start = n, end = n;
		int n1 = n, n2 = n;
		if (L == 1) {
			if (n > max) {
				start = max + 1;
				end = size;
			} else {
				start = 1;
				end = max - 1;
			}
		} else {
			while (n1 >= 1 && check[n1] == false) {
				start = n1--;
			}
			while (n2 <= size && check[n2] == false) {
				end = n2++;
			}
		}
		result = (n - start) * (end - n + 1) + (end - n);

		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();

	}

}