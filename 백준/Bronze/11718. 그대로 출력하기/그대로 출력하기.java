import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String a = sc.nextLine();
            bw.write(a + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
