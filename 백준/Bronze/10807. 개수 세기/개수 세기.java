import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(br.readLine());
		
		int[] num = new int[201];
		for(int i=0;i <N; i++) {
			num[Integer.parseInt(st.nextToken())+100]++;
		}
		
		bw.write(num[v+100]+"");
		bw.flush();
		bw.close();
		br.close();
	}

}