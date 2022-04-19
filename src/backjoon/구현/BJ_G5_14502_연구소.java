package backjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_14502_연구소 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C, map[][], clonemap[][], remain, maxRemain;
	static boolean visit[][];
	static int[][] deltas = {{1,0},{0,1},{-1,0},{0,-1}};
	static List<Point> virus = new ArrayList<>();
	public static void main(String[] args) throws IOException{
//		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		clonemap = new int[R][C];
		visit = new boolean[R][C];
		remain = 0;
		maxRemain = 0;
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				int num = Integer.parseInt(st.nextToken());
				map[r][c] = num;
				if(num == 0) remain++;
				if(num == 2) virus.add(new Point(r, c));
			}
		}
		br.close();
		remain -= 3; //벽 세울만큼 빼주기
		
		dfs(0);
		System.out.println(maxRemain);
		
	}
	
	static void dfs(int cnt) {
		if(cnt == 3) {
			visit = new boolean[R][C];
			int total = remain;
			for (int i = 0; i < virus.size(); i++) {
				total -= bfs(virus.get(i));
			}
			maxRemain = Math.max(total, maxRemain);
			return;
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] == 0) {
					map[r][c] = 1;
					dfs(cnt+1);
					map[r][c] = 0;
				}
			}
		}
		
	}
	
	static int bfs(Point v) { //감염시킨 수 리턴
		int sr = v.r;
		int sc = v.c;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sr, sc));
		visit[sr][sc] = true;
		int infectCnt = 0;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();		
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + deltas[i][0];
				int nc = cur.c + deltas[i][1];
				if(isIn(nr, nc) && !visit[nr][nc] && map[nr][nc] == 0) { //감염
					q.add(new Point(nr, nc));
					visit[nr][nc] = true;
					infectCnt++;
				}
			}
		}
		return infectCnt;
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
	
	private static class Point{
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
	
//	static String src = "8 8\r\n" + 
//			"2 0 0 0 0 0 0 2\r\n" + 
//			"2 0 0 0 0 0 0 2\r\n" + 
//			"2 0 0 0 0 0 0 2\r\n" + 
//			"2 0 0 0 0 0 0 2\r\n" + 
//			"2 0 0 0 0 0 0 2\r\n" + 
//			"0 0 0 0 0 0 0 0\r\n" + 
//			"0 0 0 0 0 0 0 0\r\n" + 
//			"0 0 0 0 0 0 0 0";
	
}
