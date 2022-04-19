package backjoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_9205_맥주마시면서걸어가기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static Point p[];
	static int distance[][], N;
	static boolean visit[];
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new FileReader("input.txt"));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			p = new Point[N+2];
			visit = new boolean[N+2];
			distance = new int[N+2][N+2];
			
			for (int i = 0; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				p[i] = new Point(x, y, i);
			}
			for (int r = 0; r < N+2; r++) {
				for (int c = 0; c < N+2; c++) {
					distance[r][c] = getDistance(p[r], p[c]);
				}
			}
			
			Queue<Point> q = new LinkedList<>();
			q.offer(p[0]);
			visit[0] = true;
			
			while(!q.isEmpty()) {
				Point cur = q.poll();
				if(cur.idx == N+1) {
					break;
				}
				
				for (int c = 0; c < N+2; c++) {
					if(!visit[c] && distance[cur.idx][c]!=0 && distance[cur.idx][c] <= 1000) {
						q.offer(p[c]);
						visit[c] = true;
					}
				}
			}
			
			
			if(!visit[N+1]) {
				sb.append("sad").append("\n");
			}else {
				sb.append("happy").append("\n");
			}
			
		}//TC
		System.out.println(sb);
		
	}//main
	
	private static int getDistance(Point a, Point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
	
	private static class Point{
		int x, y, idx;

		public Point(int x, int y, int idx) {
			super();
			this.x = x;
			this.y = y;
			this.idx = idx;
		}

		
		
	}
	
}
