package backjoon.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_2206_벽부수고이동하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int R,C, cnt;
	static boolean isArrive;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean map[][], isVisit[][][];
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new boolean[R][C];
		isVisit = new boolean[2][R][C]; //벽 부순것과 안부순것 2가지
		int temp = 0;
		isArrive = false;
		
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				temp = str.charAt(c) - '0';
				if(temp == 1) {
					map[r][c] = true;
				}
			}
		}
		
		bfs();
		
		if(!isArrive) {
			cnt = -1;
		}
		
		System.out.println(cnt);
		

	}
	
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 0));
		isVisit[0][0][0] = true;
		cnt = 1;
		
		while(!q.isEmpty()) {
			int n = q.size();
			
			while(n-->0) {
				Point cur = q.poll();
				if(cur.r == R-1 && cur.c == C-1) {
					isArrive = true;
					return;
				}
				
				for (int i = 0; i < 4; i++) {
					int nr = cur.r + dx[i];
					int nc = cur.c + dy[i];
					if(isIn(nr, nc) && !isVisit[cur.brokeCnt][nr][nc] && !map[nr][nc]) {
						q.add(new Point(nr, nc, cur.brokeCnt));
						isVisit[cur.brokeCnt][nr][nc] = true;
					}else if(isIn(nr, nc) && map[nr][nc] && cur.brokeCnt == 0 && !isVisit[1][nr][nc]) {
						//벽이 있지만 부술 수 있는 경우
						q.add(new Point(nr, nc, 1));
						isVisit[1][nr][nc] = true;
					}
					
				}
				
			}// 한바퀴 다 돌기
			cnt++;
			
		}	
	
	}

	static class Point{
		int r, c, brokeCnt;

		public Point(int r, int c, int brokeCnt) {
			super();
			this.r = r;
			this.c = c;
			this.brokeCnt = brokeCnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", bc=" + brokeCnt + "]";
		}
		
	}
	
	static boolean isIn(int r, int c) {
		return (r>=0 && r<R && c>=0 && c<C);
	}
	
	static String src = "4 4\r\n" + 
			"0111\r\n" + 
			"1111\r\n" + 
			"1111\r\n" + 
			"1110";
	
}
