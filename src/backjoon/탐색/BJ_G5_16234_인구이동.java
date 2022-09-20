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

public class BJ_G5_16234_인구이동 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N,L,R, map[][];
	static int[] dx = {1,0,0,-1};
	static int[] dy = {0,1,-1,0};
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int day = 0;
		
		while(!isEnd()) {
			day++; //하루 경과
			bfs();	
		}

		System.out.println(day);
		
	}
	
	
	
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		boolean[][] isVisit = new boolean[N][N];
		List<Point> sum = new LinkedList<>();
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!isVisit[r][c]) {
					q.add(new Point(r, c, map[r][c]));
					sum.add(new Point(r, c, map[r][c]));
					isVisit[r][c] = true;
					
					while(!q.isEmpty()) {
						Point cur = q.poll();
						
						for (int i = 0; i < 4; i++) {
							int nr = cur.r + dx[i];
							int nc = cur.c + dy[i];
							
							if(isIn(nr, nc) && !isVisit[nr][nc]) {
								int diff = Math.abs(map[cur.r][cur.c] - map[nr][nc]);
								if(diff >= L && diff <= R) {
									q.add(new Point(nr, nc, map[nr][nc]));
									sum.add(new Point(nr, nc, map[nr][nc]));
									isVisit[nr][nc] = true;
								}
							}
							
						}
						
					} // 인구이동 가능한 곳 모두 탐색 마침
					int total = 0;
					for (int i = 0; i < sum.size(); i++) {
						total += sum.get(i).num;
					}
					total /= sum.size();
					for (int i = 0; i < sum.size(); i++) {
						map[sum.get(i).r][sum.get(i).c] = total;
					}
					sum.clear();
					//인구이동 완료
					
				}
			}
		}
		
		
	}

	// 인구이동이 시작나는지 검사하는 메서드
	static boolean isEnd() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] isVisit = new boolean[N][N];
		queue.add(new Point(0, 0, 0));
		isVisit[0][0] = true;
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for (int i = 0; i < 2; i++) {
				int nr = cur.r + dx[i];
				int nc = cur.c + dy[i];
				
				if(nr<N && nc<N ) {
					int diff = Math.abs(map[cur.r][cur.c] - map[nr][nc]);
					if(diff >= L && diff <= R) {
						return false;
					}
					if(!isVisit[nr][nc]) {
						queue.add(new Point(nr, nc, 0));
						isVisit[nr][nc] = true;						
					}
					
				}
			}
			
		}
		
		return true;
	}
	
	static class Point{
		int r,c,num;

		public Point(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}
		
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
	
	static String src = "5 1 5\r\n" + 
			"88 27 34 84 9\r\n" + 
			"40 91 11 30 81\r\n" + 
			"2 88 65 26 75\r\n" + 
			"75 66 16 14 28\r\n" + 
			"89 10 5 30 75";
	
}
