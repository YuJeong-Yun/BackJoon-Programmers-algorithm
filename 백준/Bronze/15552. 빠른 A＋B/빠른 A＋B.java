import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// BufferReader/BufferWriter 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt = Integer.parseInt(br.readLine());
		String input;
		int num1, num2;

		for (int i = 0; i < cnt; i++) {
			input = br.readLine();
			
			num1 = Integer.parseInt(input.split(" ")[0]);
			num2 = Integer.parseInt(input.split(" ")[1]);
			
			bw.write(num1 + num2+"\n");
		}
		bw.flush();
		br.close();
	}
}
