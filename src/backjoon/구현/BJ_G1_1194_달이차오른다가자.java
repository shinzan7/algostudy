package backjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G1_1194_달이차오른다가자 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int R, C, sr, sc;
	static char[][] map;
	static boolean[][][] visit;
	static int[][] deltas = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C][1<<6];
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				char temp = str.charAt(c);
				map[r][c] = temp;
				if(temp == '0') { //시작위치 저장하고 평지로 만들기
					sr = r;
					sc = c;
					map[r][c] = '.'; 
				}
			}
		}
		br.close();

		System.out.println(bfs());
		
	}
	
	private static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(sr, sc, 0));
		visit[sr][sc][0] = true;
		int depth = 1;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-- > 0) {
				Point cur = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nr = cur.r + deltas[i][0];
					int nc = cur.c + deltas[i][1];
					
					if(nr>=0 && nr<R && nc>=0 && nc<C && !visit[nr][nc][cur.keyFlag]) {
						//평지
						if(map[nr][nc] == '.') {
							q.offer(new Point(nr, nc, cur.keyFlag));
							visit[nr][nc][cur.keyFlag] = true;
						}
						//벽
						else if(map[nr][nc] == '#') {
							continue;
						}
						//열쇠
						else if(map[nr][nc] == 'a' || map[nr][nc] == 'b' || map[nr][nc] == 'c' 
								|| map[nr][nc] == 'd' || map[nr][nc] == 'e' || map[nr][nc] == 'f') {
							Point temp = new Point(nr, nc, cur.keyFlag);
							temp.getKey(map[nr][nc]);
							q.offer(temp);
							visit[nr][nc][cur.keyFlag] = true;
							visit[nr][nc][temp.keyFlag] = true;
						}
						//잠긴 문
						else if(map[nr][nc] == 'A' || map[nr][nc] == 'B' || map[nr][nc] == 'C' 
								|| map[nr][nc] == 'D' || map[nr][nc] == 'E' || map[nr][nc] == 'F') {
							if(loveIsOpenDoor(cur.keyFlag, map[nr][nc])) {
								q.offer(new Point(nr, nc, cur.keyFlag));
								visit[nr][nc][cur.keyFlag] = true;
							}
						}
							
						//탈출구
						else if(map[nr][nc] == '1') {
							return depth;
						}
						
					}
					
				}
				
			}//한바퀴
			depth++;
			
		}
		//길 못찾는 경우
		return -1;
	}
	
	private static boolean loveIsOpenDoor(int keyFlag, char door) {
		if((keyFlag & 1<<(door - 'A')) > 0) {
			return true;
		}
		return false;
	}
	
	private static class Point{
		int r,c;
		int keyFlag;

		public Point(int r, int c, int keyFlag) {
			super();
			this.r = r;
			this.c = c;
			this.keyFlag = keyFlag;
		}

		public void getKey(char key) {
			 this.keyFlag |= 1<<(key - 'a');
		}
	}
	
	static String src = "7 8\r\n" + 
			"a#c#eF.1\r\n" + 
			".#.#.#..\r\n" + 
			".#B#D###\r\n" + 
			"0....F.1\r\n" + 
			"C#E#A###\r\n" + 
			".#.#.#..\r\n" + 
			"d#f#bF.1";
	
}
