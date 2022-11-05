import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int whiteLen = 100, blackLen = 10;
		int N = Integer.parseInt(br.readLine());
		boolean[][] check = new boolean[100][100];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dist1 = Integer.parseInt(st.nextToken());
			int dist2 = Integer.parseInt(st.nextToken());
			for (int j = dist1; j < dist1 + blackLen; j++) {
				for (int k = whiteLen - blackLen - dist2; k < whiteLen - dist2; k++) {
					check[j][k] = true;
				}
			}
		}
		
		int total=0;
		for(int i=0; i<whiteLen; i++) {
			for(int j=0; j<whiteLen; j++) {
				if(check[i][j]) {
					total++;
				}
			}
		}

		bw.write(total+"");
		bw.flush();
		bw.close();
		br.close();
	}

}