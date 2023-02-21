import java.util.*;
import java.io.*;

public class Main {
	static int[][] ch;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long answer = 0l;
		for (int i = 0; i < 3; i++) {
			String color = br.readLine();
			if (i < 2) {
				answer = answer * 10 + matchColor(color);
			} else {
				answer *= Math.pow(10, matchColor(color));
			}

		}

		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int matchColor(String color) {
		int result = 0;
		switch (color) {
		case "brown":
			result = 1;
			break;
		case "red":
			result = 2;
			break;
		case "orange":
			result = 3;
			break;
		case "yellow":
			result = 4;
			break;
		case "green":
			result = 5;
			break;
		case "blue":
			result = 6;
			break;
		case "violet":
			result = 7;
			break;
		case "grey":
			result = 8;
			break;
		case "white":
			result = 9;
			break;
		}
		return result;

	}
}
