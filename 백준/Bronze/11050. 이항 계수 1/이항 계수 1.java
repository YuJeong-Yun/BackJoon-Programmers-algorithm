import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());

		int resultNum = 1, divideNum = 1, temp = num2;
		for (int i = 0; i < num2; i++) {
			resultNum *= num1--;
			divideNum *= temp--;
		}
		resultNum /= divideNum;

		bw.write(resultNum + "");

		bw.flush();
		bw.close();
		br.close();
	}
}