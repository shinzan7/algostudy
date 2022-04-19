package backjoon.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_7562_나이트의이동 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, R, C, DR, DC, count;
	static boolean map[][];
	static int deltas[][] = {{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine()); //체스판의 크기
			map = new boolean[N][N];
			
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken()); //나이트의 현재 칸
			C = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			DR = Integer.parseInt(st.nextToken()); //나이트의 목적지
			DC = Integer.parseInt(st.nextToken());
			count = 0; //이동횟수
				
			bfs();
			sb.append(count).append("\n");

		}//T.C
		System.out.println(sb);
	}//main
	
	static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(R, C));
		map[R][C] = true;
		
		while(!map[DR][DC]) { //목적지에 도달할때까지
			int size = q.size();
			while(size-- > 0) {
				Point current = q.poll();
				
				for (int i = 0; i < deltas.length; i++) {
					int nr = current.r + deltas[i][0]; //갈곳
					int nc = current.c + deltas[i][1];
					
					//범위 안이면서 방문하지 않은곳일 때
					if(nr>=0 && nr<N && nc>=0 && nc<N && !map[nr][nc]) {
						q.offer(new Point(nr, nc));
						map[nr][nc] = true;
					}
				}
				
			}// 한바퀴 다 돌음
			count++;
			
		}//목적지에 도달하면 반복문 종료됨
	}
	
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "[r=" + r + ", c=" + c + "]";
		}
		
	}

	
}
