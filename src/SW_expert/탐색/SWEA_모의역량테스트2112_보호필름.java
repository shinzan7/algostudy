package SW_expert.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_모의역량테스트2112_보호필름 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int D, W, K, min;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new boolean[D][W];
			min = Integer.MAX_VALUE;
			for (int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					if (Integer.parseInt(st.nextToken()) == 1) {
						map[r][c] = true;
					}
				}
			} // 입력완료
			dfs(0, 0);
			sb.append("#").append(t);
			sb.append(" ").append(min).append("\n");
		} // T.C
		System.out.println(sb);
	}// main

	private static void dfs(int r, int cnt) {
		if (cnt > min)
			return; // 가지치기
		
		if (check()) {
			min = Math.min(min, cnt);
			return;
		}
		if (r == D)
			return;

		boolean[] original = map[r].clone();
		// 처리안함
		dfs(r + 1, cnt);

		// A처리
		Arrays.fill(map[r], false);
		dfs(r + 1, cnt + 1);

		// B처리
		Arrays.fill(map[r], true);
		dfs(r + 1, cnt + 1);

		// 원상복구
		map[r] = original.clone();

	}

	private static boolean check() {
		out: for (int c = 0; c < W; c++) {
			boolean current = map[0][c];
			int cnt = 1;
			for (int r = 1; r < D; r++) {
				if (map[r][c] == current)
					cnt++;
				else
					cnt = 1;
				current = map[r][c];
				if(cnt >= K) continue out;				
			}
			return false;
		}

		return true;
	}

	static String src = "1\r\n" + 
			"2 2 2\r\n" + 
			"1 0\r\n" + 
			"0 1";

}
