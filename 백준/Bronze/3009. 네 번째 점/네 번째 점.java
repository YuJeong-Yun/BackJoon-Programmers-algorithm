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

		int[] xArr = new int[3];
		int[] yArr = new int[3];

		StringTokenizer st;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			xArr[i] = Integer.parseInt(st.nextToken());
			yArr[i] = Integer.parseInt(st.nextToken());
		}

		int x, y;

		x = xArr[0] == xArr[1] ? xArr[2] : (xArr[0] == xArr[2] ? xArr[1] : xArr[0]);
		y = yArr[0] == yArr[1] ? yArr[2] : (yArr[0] == yArr[2] ? yArr[1] : yArr[0]);

		bw.write(x + " " + y);

		bw.flush();
		bw.close();
		br.close();
	}
}