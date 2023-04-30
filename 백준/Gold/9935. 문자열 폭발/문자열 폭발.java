import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String bomb = br.readLine();
        int len = bomb.length();

        Stack<Character> stack = new Stack<>();
        out:
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);

            if (c == bomb.charAt(len - 1) && stack.size() >= len) { // 폭발 문자열의 마지막 글자와 같으면 && 스택에 bomb 길이만큼 남아있으면
                for (int j = 0; j < len; j++) {
                    if (stack.get(stack.size() - len + j) != bomb.charAt(j)) { // 폭발 문자열과 다르면 넘어감
                        continue out;
                    }
                }
                for (int j = 0; j < len; j++) {
                    stack.pop();
                }
            }
        }


        if (!stack.isEmpty()) {
            for (char c : stack) {
                bw.write(c + "");
            }
        } else {
            bw.write("FRULA");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}