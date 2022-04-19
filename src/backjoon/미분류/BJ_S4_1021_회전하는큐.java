package backjoon.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S4_1021_회전하는큐 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, count, currentIdx;
	static List<Integer> list = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		count = 0;
		currentIdx = 0;

		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int m = Integer.parseInt(st.nextToken()); // 제거할 번호
			int idx = list.indexOf(m);
			if (currentIdx == idx) {
				list.remove(idx);
			} else {
				int moveCnt = 0;
				if (currentIdx > idx) {
					moveCnt = (currentIdx - idx < idx + list.size() - currentIdx) ? currentIdx - idx
							: idx + list.size() - currentIdx;
					count += moveCnt;
					
					if(idx == list.size()-1) {
						currentIdx = 0;
					}else {
						currentIdx = idx;
					}
					list.remove(idx);
					
				} else if (currentIdx < idx) {
					moveCnt = (idx - currentIdx < currentIdx + list.size() - idx) ? idx - currentIdx
							: currentIdx + list.size() - idx;
					count += moveCnt;
					
					if(idx == list.size()-1) {
						currentIdx = 0;
					}else {
						currentIdx = idx;
					}
					list.remove(idx);
				}

			}

		}
		System.out.println(count);

	}

}
