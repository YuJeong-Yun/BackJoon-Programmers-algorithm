import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 2; i++) {
			bw.write(1 - Integer.parseInt(st.nextToken()) + " ");
		}
		for (int i = 0; i < 3; i++) {
			bw.write(2 - Integer.parseInt(st.nextToken()) + " ");
		}
		bw.write(8 - Integer.parseInt(st.nextToken()) + "");

		bw.flush();
		bw.close();
		br.close();
	}
}