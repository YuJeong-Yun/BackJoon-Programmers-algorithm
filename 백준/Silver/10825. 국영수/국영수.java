import java.io.*;
import java.sql.Array;
import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int korean, english, math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Student s) {
        if (this.korean == s.korean) {
            if (this.english == s.english) {
                if (this.math == s.math) {
                    return this.name.compareTo(s.name);
                }
                return s.math - this.math;
            }
            return this.english - s.english;
        }
        return s.korean - this.korean;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            list.add(new Student(name, k, e, m));
        }

        Collections.sort(list);
        for (Student s : list) {
            bw.write(s.name + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

}