import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String word = br.readLine();
			bw.write(word.charAt(0));
			bw.write(word.charAt(word.length()-1)+"\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}