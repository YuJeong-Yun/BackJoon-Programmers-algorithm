
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Stack<Character> stk = new Stack<>();
            String s = br.readLine();
            String answer = "YES";

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stk.push('(');
                } else {
                    if (stk.isEmpty() || stk.peek() == ')') {
                        answer = "NO";
                        break;
                    } else {
                        stk.pop();
                    }
                }
            }
            if (!stk.isEmpty()) {
                answer = "NO";
            }
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}