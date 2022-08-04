import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt = Integer.parseInt(br.readLine());

		ArrayList<Integer> width = new ArrayList<>();
		ArrayList<Integer> height = new ArrayList<>();

		StringTokenizer st;
		int dir, num, chk = 0;
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());

			if (i == 0) {
				chk = dir;
			}

			switch (dir) {
			case 1:
			case 2:
				width.add(num);
				break;
			case 3:
			case 4:
				height.add(num);
				break;
			}
		}

		int maxW = Collections.max(width);
		int maxH = Collections.max(height);
		int idxW = width.indexOf(maxW);
		int idxH = height.indexOf(maxH);

		int idxAW = 0, idxAH = 0;
		if (chk < 3) {
			idxAW = idxW * 2;
			idxAH = idxH * 2 + 1;
		} else {
			idxAW = idxW * 2 + 1;
			idxAH = idxH * 2;
		}

		int calcW = 0, calcH = 0;
		if (idxAW - idxAH == 1 || idxAW - idxAH == -5) {
			calcW = idxW == 2 ? 0 : idxW + 1;
			calcH = idxH == 0 ? 2 : idxH - 1;
		} else {
			calcW = idxW == 0 ? 2 : idxW - 1;
			calcH = idxH == 2 ? 0 : idxH + 1;
		}

		calcW = width.get(calcW);
		calcH = height.get(calcH);

		bw.write((maxW * maxH - calcW * calcH) * cnt + "");

		bw.flush();
		bw.close();
		br.close();
	}
}