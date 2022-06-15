import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		s = s.replaceAll("c=", "1").
				replaceAll("c-", "1")
				.replaceAll("dz=", "1")
				.replaceAll("d-", "1")
				.replaceAll("lj", "1")
				.replaceAll("nj", "1")
				.replaceAll("s=", "1")
				.replace("z=", "1");

		bw.write(s.length() + "");
		bw.flush();
		bw.close();
		br.close();
	}
}