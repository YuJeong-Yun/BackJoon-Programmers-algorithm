import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class ListQueue {
	ArrayList<Integer> queue = new ArrayList<>();
	int size = 0;
	int front = 0;
	int end = -1;

	public void push(int X) {
		queue.add(X);
		size++;
		end++;
	}

	public int pop() {
		if (size == 0) {
			return -1;
		} else {
			size--;
			return queue.get(front++);
		}
	}

	public int size() {
		return size;
	}

	public int empty() {
		if (size == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public int front() {
		if (size == 0) {
			return -1;
		} else {
			return queue.get(front);
		}
	}

	public int back() {
		if (size == 0) {
			return -1;
		} else {
			return queue.get(end);
		}
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		ListQueue que = new ListQueue();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
			case "push":
				int X = Integer.parseInt(st.nextToken());
				que.push(X);
				break;
			case "pop":
				bw.write(que.pop() + "\n");
				break;
			case "size":
				bw.write(que.size() + "\n");
				break;
			case "empty":
				bw.write(que.empty() + "\n");
				break;
			case "front":
				bw.write(que.front() + "\n");
				break;
			case "back":
				bw.write(que.back() + "\n");
				break;
			default:
				break;
			}

		}

		bw.flush();
		bw.close();
		br.close();
	}
}