package backjoon.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_2636_치즈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int R, C, map[][], answer, remainCheese, lastRemain;
	static int deltas[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		answer = 0; // 걸린시간
		remainCheese = 0; // 남아있는 치즈
		lastRemain = 0;
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				int n = Integer.parseInt(st.nextToken());
				map[r][c] = n;
				if (n == 1)
					remainCheese++;
			}
		} // 입력완료

		while(lastRemain == 0) {
			melt();
		}
		sb.append(answer).append("\n");
		sb.append(lastRemain);
		System.out.println(sb);
		
	}

	private static void melt() { // 한시간동안 녹이기

		boolean[][] visit = new boolean[R][C];
		Queue<Point> q = new LinkedList<>();
		List<Point> toMelt = new LinkedList<>();
		q.offer(new Point(0, 0)); // 출발점
		visit[0][0] = true;

		while (!q.isEmpty()) {
			Point current = q.poll();

			for (int i = 0; i < deltas.length; i++) {
				int nr = current.r + deltas[i][0];
				int nc = current.c + deltas[i][1];

				if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[nr][nc]) {
					if(map[nr][nc] == 0) { //공기
						q.offer(new Point(nr, nc));
						visit[nr][nc] = true;
					}else if(map[nr][nc] == 1) { //겉부분 치즈
						remainCheese--;
						visit[nr][nc] = true;
						map[nr][nc] = 2;
						toMelt.add(new Point(nr, nc));
					}else{ //녹을 치즈
						visit[nr][nc] = true;
					}
				}
			}
		}
		
		if(remainCheese == 0) {
			//남은 치즈 0일때 숫자2 개수 리턴
			lastRemain = toMelt.size();
			answer++;
			return;
		}
		
		for (int i = 0; i < toMelt.size(); i++) {
			int r = toMelt.get(i).r;
			int c = toMelt.get(i).c;
			map[r][c] = 0;
		}
		

		answer++;

	}

	private static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

	static String src = "13 12\r\n" + "0 0 0 0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0 0 1 1 0 0 0\r\n" + "0 1 1 1 0 0 0 1 1 0 0 0\r\n" + "0 1 1 1 1 1 1 0 0 0 0 0\r\n"
			+ "0 1 1 1 1 1 0 1 1 0 0 0\r\n" + "0 1 1 1 1 0 0 1 1 0 0 0\r\n" + "0 0 1 1 0 0 0 1 1 0 0 0\r\n"
			+ "0 0 1 1 1 1 1 1 1 0 0 0\r\n" + "0 0 1 1 1 1 1 1 1 0 0 0\r\n" + "0 0 1 1 1 1 1 1 1 0 0 0\r\n"
			+ "0 0 1 1 1 1 1 1 1 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0 0 0";

}
