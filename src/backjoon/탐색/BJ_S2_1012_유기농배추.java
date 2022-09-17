package backjoon.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_1012_유기농배추 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static boolean[][] map, isVisit;
	static int worm, R, C;
	static int[][] deltas = {{1,0},{0,1},{0,-1},{-1,0}};
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {			
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new boolean[R][C];
			isVisit = new boolean[R][C];
			worm = 0;
			
			int numCabbage = Integer.parseInt(st.nextToken());
			for (int i = 0; i < numCabbage; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = true; //양배추 심은곳
			}
			
			bfs();
			
			//dfs로 풀기
//			for (int r = 0; r < R; r++) {
//				for (int c = 0; c < C; c++) {
//					if(map[r][c] && !isVisit[r][c]) {
//						worm++;
//						dfs(r, c);
//					}
//				}
//			}
			
			sb.append(worm).append("\n");
		}//TC
		System.out.println(sb);
	}//main
	
	static boolean isIn(int r, int c) {
		return (r>=0 && r<R && c>=0 && c<C);
	}
	
	private static void dfs(int cr, int cc) {
		isVisit[cr][cc] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = cr + deltas[i][0];
			int nc = cc + deltas[i][1];
			
			if(isIn(nr, nc) && map[nr][nc] && !isVisit[nr][nc]) {
				dfs(nr, nc);
			}
		}
		
	}
	
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				//시작점 찾기
				if(map[r][c] && !isVisit[r][c]) {
					worm++;
					q.add(new Point(r, c));
					isVisit[r][c] = true;
					
					while(!q.isEmpty()) {
						Point cur = q.poll();
						
						for (int i = 0; i < 4; i++) {
							int nr = cur.r + deltas[i][0];
							int nc = cur.c + deltas[i][1];
							
							if(isIn(nr, nc) && map[nr][nc] && !isVisit[nr][nc]) {
								q.add(new Point(nr, nc));
								isVisit[nr][nc] = true;
							}
						}
						
					}
					
				}
				
			}
		}
		
	}
	
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}

	static String src = "1\r\n" + 
			"5 3 6\r\n" + 
			"0 2\r\n" + 
			"1 2\r\n" + 
			"2 2\r\n" + 
			"3 2\r\n" + 
			"4 2\r\n" + 
			"4 0";
	
}
