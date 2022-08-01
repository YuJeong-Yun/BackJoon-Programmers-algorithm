import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		int cnt = 0;

		Set<String> strSet = new HashSet<>();

		for (int j = 1; j <= str.length(); j++) {
			for (int i = 0; i + j <= str.length(); i++) {
				strSet.add(str.substring(i, i + j));
			}
		}

		bw.write(strSet.size() + "");

		bw.flush();
		bw.close();
		br.close();
	}
}