import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int i = 2;
		while (true) {
			if (N % i == 0) {
				sb.append(i + "\n");
				N /= i--;
			}
			if (N == 1) break;
			i++;
		}

		System.out.println(sb);
		br.close();
	}
}