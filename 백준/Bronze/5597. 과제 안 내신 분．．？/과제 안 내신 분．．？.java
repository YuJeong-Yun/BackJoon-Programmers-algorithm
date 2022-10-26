import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int student = 30,cnt=28;
		boolean[] check = new boolean[student];
		for(int i=0; i<cnt; i++) {
			check[Integer.parseInt(br.readLine())-1]= true ;
		}
		for(int i=0; i<student; i++) {
			if(!check[i]) {
				bw.write(i+1+"\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}