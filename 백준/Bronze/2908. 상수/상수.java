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

		StringTokenizer nums = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(nums.nextToken());
		int num2 = Integer.parseInt(nums.nextToken());

		int newNum1 = num1 % 10 * 100 + num1 % 100 / 10 * 10 + num1 / 100;
		int newNum2 = num2 % 10 * 100 + num2 % 100 / 10 * 10 + num2 / 100;

		int bigNum = (newNum1 > newNum2 ? newNum1 : newNum2);

		bw.write(bigNum + "");
		bw.flush();
		bw.close();
		br.close();
	}
}