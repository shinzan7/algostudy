package SW_expert.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_D4_문제해결응용_보급로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, map[][], minTime;
	static int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				String str = br.readLine();
				for (int c = 0; c < N; c++) {
					map[r][c] = str.charAt(c) - '0';
				}
			} // 입력완료

			minTime = 0;

			daik();

			sb.append("#").append(t).append(" ");
			sb.append(minTime).append("\n");

		} // TC
		System.out.println(sb);
	}// main

	private static class Point implements Comparable<Point> {
		int r, c, dis;

		public Point(int r, int c, int dis) {
			super();
			this.r = r;
			this.c = c;
			this.dis = dis;
		}

		@Override
		public int compareTo(Point o) {
			return this.dis - o.dis;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", dis=" + dis + "]";
		}

	}

	private static void daik() {
		boolean[][] visit = new boolean[N][N];
		PriorityQueue<Point> pq = new PriorityQueue<>();

		pq.offer(new Point(0, 0, 0));

		while (!pq.isEmpty()) {
			// 미방문 & 최소비용 정점선택
			Point cur = pq.poll();
			if(cur.r == N-1 && cur.c == N-1) {
				minTime = cur.dis;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc]) {
					// 추가될때마다 최소비용 갱신
					visit[nr][nc] = true;
					pq.offer(new Point(nr, nc, cur.dis + map[nr][nc]));
				}
			}

		}

	}
}
