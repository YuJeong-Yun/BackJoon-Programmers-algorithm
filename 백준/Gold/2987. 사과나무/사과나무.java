import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xList.add(Integer.parseInt(st.nextToken()));
            yList.add(Integer.parseInt(st.nextToken()));
        }
        double area = calcSize(xList.get(0), xList.get(1), xList.get(2), yList.get(0), yList.get(1), yList.get(2));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int maxY = Collections.max(yList);
        int minY = Collections.min(yList);
        int maxX = Collections.max(xList);
        int minX = Collections.min(xList);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x < minX || x > maxX || y < minY || y > maxY) {
                continue;
            }

            double totalArea = 0;
            totalArea += calcSize(x, xList.get(0), xList.get(1), y, yList.get(0), yList.get(1));
            totalArea += calcSize(x, xList.get(0), xList.get(2), y, yList.get(0), yList.get(2));
            totalArea += calcSize(x, xList.get(1), xList.get(2), y, yList.get(1), yList.get(2));

            if (totalArea == area) {
                answer++;
            }
        }

        bw.write(area + "\n" + answer);
        bw.flush();
        bw.close();
        br.close();
    }

    public static double calcSize(int x1, int x2, int x3, int y1, int y2, int y3) {
        return Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
    }
}
