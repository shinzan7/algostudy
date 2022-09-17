package backjoon.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_2468_안전영역 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N, maxFloor;
	static int[][] map;
	static boolean[][] isWater;
	static boolean[][] isVisit;
	static int maxCount;
	static int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException{
//		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		isVisit = new boolean[N][N];
		maxFloor = 0;
		maxCount = 1;
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] > maxFloor) maxFloor = map[r][c];
			}
		}
		
		for (int i = 1; i < maxFloor; i++) { //1부터 최대층전까지 비 내리는 경우
			isWater = new boolean[N][N];
			isVisit = new boolean[N][N];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] <= i) {
						isWater[r][c] = true;
						isVisit[r][c] = true;
					}
				}
			}
			bfs();
		}
		
		System.out.println(maxCount);

	} //main
	
	static boolean isIn(int r, int c) {
		return (r>=0 && r<N && c>=0 && c<N);
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		
		int cnt = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!isWater[r][c] && !isVisit[r][c]) { //물에 잠겨있지 않고 방문한적 없으면 q 넣기
					cnt++; //구역 횟수 +1
					q.add(new Point(r, c));
					isVisit[r][c] = true;
					
					while(!q.isEmpty()) {
						Point current = q.poll();
						
						for (int i = 0; i < 4; i++) {
							int nr = current.r + delta[i][0];
							int nc = current.c + delta[i][1];
							
							//사방탐색하기
							if(isIn(nr, nc) && !isVisit[nr][nc] && !isWater[nr][nc]) {
								q.add(new Point(nr, nc));
								isVisit[nr][nc] = true;
							}
							
						}
						
					}//끝까지 탐색했으면

				}
				
			}
		} //모든 구간 탐색끝
		//최대기록 갱신
		if(cnt > maxCount) maxCount = cnt;
		
	}
	
	
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
//	static String src = "7\r\n" + 
//			"9 9 9 9 9 9 9\r\n" + 
//			"9 2 1 2 1 2 9\r\n" + 
//			"9 1 8 7 8 1 9\r\n" + 
//			"9 2 7 9 7 2 9\r\n" + 
//			"9 1 8 7 8 1 9\r\n" + 
//			"9 2 1 2 1 2 9\r\n" + 
//			"9 9 9 9 9 9 9";
	
}
