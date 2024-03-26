

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Stack<String> stk = new Stack<>();


        for (char c : str.toCharArray()) {
//            System.out.println("->  " + c);

            if (c == '(') {
                stk.push("(");
            } else if (c == ')') {
                if (stk.isEmpty() || stk.peek().equals("[")) {
                    stk.clear();
                    break;
                } else if (stk.peek().matches("\\d+")) {
                    int tmp = Integer.parseInt(stk.pop());
                    if (stk.isEmpty() || !stk.peek().equals("(")) {
                        stk.clear();
                        break;
                    }
                    stk.pop(); // ( 제거
                    if (!stk.isEmpty() && stk.peek().matches("\\d+")) {
                        stk.push(Integer.parseInt(stk.pop()) + tmp * 2 + "");
                    } else {
                        stk.push(tmp * 2 + ""); // 3.(X) 케이스인 경우
                    }
                } else if (stk.peek().equals("(")) {
                    stk.pop();
                    if (!stk.isEmpty() && stk.peek().matches("\\d+")) {
                        stk.push(Integer.parseInt(stk.pop()) + 2 + "");
                    } else {
                        stk.push("2");
                    }
                }


            } else if (c == '[') {
                stk.push("[");
            } else {
                if (stk.isEmpty() || stk.peek().equals("(")) {
                    stk.clear();
                    break;
                } else if (stk.peek().matches("\\d+")) {
                    int tmp = Integer.parseInt(stk.pop());
                    if (stk.isEmpty() || !stk.peek().equals("[")) {
                        stk.clear();
                        break;
                    }
                    stk.pop(); // [ 제거
                    if (!stk.isEmpty() && stk.peek().matches("\\d+")) {
                        stk.push(Integer.parseInt(stk.pop()) + tmp * 3 + "");
                    } else {
                        stk.push(tmp * 3 + ""); // 4.[X] 케이스인 경우
                    }
                } else if (stk.peek().equals("[")) {
                    stk.pop();
                    if (!stk.isEmpty() && stk.peek().matches("\\d+")) {
                        stk.push(Integer.parseInt(stk.pop()) + 3 + "");
                    } else {
                        stk.push("3");
                    }
                }

            }
//            System.out.println(stk);
        }

        int answer = 0;
        for (String s : stk) {
            if (s.matches("\\d+")) {
                answer += Integer.parseInt(s);
            } else {
                answer = 0;
                break;
            }
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
