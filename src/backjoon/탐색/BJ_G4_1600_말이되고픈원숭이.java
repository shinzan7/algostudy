package backjoon.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_1600_말이되고픈원숭이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static boolean visit[][][];
	static int K, C, R, map[][];
	static int deltas[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int jumps[][] = { { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 } };

	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new StringReader(src));
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[K + 1][R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		} // 입력완료
		br.close();
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0, 0, K));
		visit[K][0][0] = true;

		while (!q.isEmpty()) {
				Point current = q.poll();
				int r = current.r;
				int c = current.c;
				int cnt = current.count;
				int j = current.remainJump;
				
				if (r == R - 1 && c == C - 1) { // 목적지 도착
					return cnt;
				}

				for (int i = 0; i < deltas.length; i++) { // 인접 사방탐색
					int nr = r + deltas[i][0];
					int nc = c + deltas[i][1];

					if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[j][nr][nc]) {
						if (map[nr][nc] == 0) {
							q.offer(new Point(nr, nc, cnt + 1, j));
							visit[j][nr][nc] = true;
						}
					}
				}
				if (j != 0) { // 점프횟수 남아있으면
					for (int i = 0; i < jumps.length; i++) {
						int nr = r + jumps[i][0];
						int nc = c + jumps[i][1];

						if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[j-1][nr][nc]) {
							if (map[nr][nc] == 0) {
								q.offer(new Point(nr, nc, cnt + 1, j - 1));
								visit[j - 1][nr][nc] = true;
							}
						}
					}
				}

		} // while
		//모두 탐색해도 목적지에 가지못하면
		return -1;

	}

	private static class Point {
		int r, c, count, remainJump;

		public Point(int r, int c, int count, int remainJump) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
			this.remainJump = remainJump;
		}

	}

//	static String src = "2\r\n" + "5 2\r\n" + "0 0 1 1 0\r\n" + "0 0 1 1 0";

}
