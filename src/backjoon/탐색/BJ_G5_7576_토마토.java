package backjoon.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_7576_토마토 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int C, R, map[][];
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int day = 0; // 정답
	static int left = 0; // 익지않은 토마토 개수
	static Queue<tomato> ripeQ = new LinkedList<tomato>();

	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				int a = Integer.parseInt(st.nextToken());
				map[r][c] = a;
				if (a == 1) {// 익은토마토 큐에 넣기
					ripeQ.offer(new tomato(r, c));
				} else if (a == 0)
					left++;
			}
		}
		br.close();
		if (left != 0)
			bfs(); // 익지않은 토마토가 있다면 bfs
		System.out.println(day);

	}// main

	static void bfs() {
		// 처음 익어있는 토마토들에 대하여 큐에 익힌 토마토들 넣어주기
		while (!ripeQ.isEmpty()) {
			int qSize = ripeQ.size();
			while (qSize-- > 0) {
				tomato current = ripeQ.poll();

				for (int i = 0; i < 4; i++) {
					int nr = current.r + deltas[i][0];
					int nc = current.c + deltas[i][1];

					if (canGo(nr, nc)) {
						// 토마토 익히기
						ripeQ.offer(new tomato(nr, nc));
						map[nr][nc] = 1;
						left--;
					}

				}

			} // 하루 끝
			day++;
			if (left == 0)
				break;

		} // 전체 끝
		if (left != 0)
			day = -1; // 익지않은 토마토 남아있으면

	}

	// 익은토마토
	static class tomato {
		int r, c;

		public tomato(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "[r=" + r + ", c=" + c + "]";
		}

	}

	static boolean canGo(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && map[r][c] == 0;
	}

//	static String src = "6 4\r\n" + 
//			"0 0 0 0 0 0\r\n" + 
//			"0 0 0 0 0 0\r\n" + 
//			"0 0 0 0 0 0\r\n" + 
//			"0 0 0 0 0 1";

}
