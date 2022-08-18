import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> stack = new ArrayList<>();
	static int size = 0;

	public static void push(int X) {
		stack.add(X);
		size++;
	}

	public static void pop() {
		if (size == 0) {
			sb.append("-1\n");
		} else {
			sb.append(stack.get(size - 1) + "\n");
			stack.remove(size - 1);
			size--;
		}
	}

	public static void size() {
		sb.append(size + "\n");
	}

	public static void empty() {
		int result = size == 0 ? 1 : 0;
		sb.append(result + "\n");
	}

	public static void top() {
		int result = size == 0 ? -1 : stack.get(size - 1);
		sb.append(result + "\n");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				int X = Integer.parseInt(st.nextToken());
				push(X);
				break;
			case "pop":
				pop();
				break;
			case "size":
				size();
				break;
			case "empty":
				empty();
				break;
			case "top":
				top();
				break;
			default:
				break;
			}
		}

		System.out.println(sb);
		br.close();
	}
}