package SW_expert.미분류;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_모의역량테스트1953_탈주범검거 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int R, C, HR, HC, L, map[][];
	static int deltas[][] = {{-1,0},{1,0},{0,-1},{0,1}}; //0123 상하좌우
	static int[] up = {1, 2, 5, 6};
	static int[] down = {1, 2, 4, 7};
	static int[] right = {1, 3, 6, 7};
	static int[] left = {1, 3, 4, 5};

	static int[][] types;
	public static void main(String[] args) throws IOException{
//		br = new BufferedReader(new FileReader("input.txt"));
		int T = Integer.parseInt(br.readLine());
		types = new int[8][];
		types[1] = new int[] {0,1,2,3};
		types[2] = new int[] {0,1};
		types[3] = new int[] {2,3};
		types[4] = new int[] {0,3};
		types[5] = new int[] {1,3};
		types[6] = new int[] {1,2};
		types[7] = new int[] {0,2};
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken()); //지도 세로크기
			C = Integer.parseInt(st.nextToken()); //지도 가로크기
			HR = Integer.parseInt(st.nextToken()); //맨홀 뚜껑 R
			HC = Integer.parseInt(st.nextToken()); //맨홀 뚜껑 C
			L = Integer.parseInt(st.nextToken()); //탈출 후 소요된시간
			map = new int[R][C];
			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}//입력완료

			sb.append("#").append(t).append(" ").append(bfs()).append("\n");
		}//TC
		System.out.println(sb);
	}//main
	
	private static int bfs() {
		int count = 0;
		int LeftTime = L;
		Queue<Pipe> q = new LinkedList<>();
		boolean[][] visit = new boolean[R][C];
		q.offer(new Pipe(HR, HC, map[HR][HC]));
		visit[HR][HC] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-- > 0) {
				Pipe cur = q.poll();
				count++;
				
				for (int i = 0; i < 4; i++) {
					if(canLeave(i, cur.type)) {
						int nr = cur.r + deltas[i][0];
						int nc = cur.c + deltas[i][1];
						if(isIn(nr, nc) && canArrive(i, map[nr][nc]) && !visit[nr][nc]) {
							q.offer(new Pipe(nr, nc, map[nr][nc]));
							visit[nr][nc] = true;		
						}
						
					}
				}
				
			}//한시간 지남
			LeftTime--;
			if(LeftTime == 0) break;
		}
		
		
		return count;
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
	
	private static boolean canLeave(int dir, int type) { //방향 타일 출발가능한지
		for (int i = 0; i < types[type].length; i++) {
			if(dir == types[type][i]) return true;
		}
		
		return false;
	}
	
	private static boolean canArrive(int dir, int type) { //방향과 타입넣으면 갈수있는지
		if(dir == 0) {//상
			for (int i = 0; i < 4; i++) {
				if(type == up[i]) return true;
			}
		}else if(dir == 1) {//하
			for (int i = 0; i < 4; i++) {
				if(type == down[i]) return true;
			}
		}else if(dir == 2) {//좌
			for (int i = 0; i < 4; i++) {
				if(type == left[i]) return true;
			}
		}else {//우
			for (int i = 0; i < 4; i++) {
				if(type == right[i]) return true;
			}
		}
				
		return false;
	}
	
	private static class Pipe{
		int r, c, type;

		public Pipe(int r, int c, int type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
		}

		@Override
		public String toString() {
			return "Pipe [r=" + r + ", c=" + c + ", type=" + type + "]";
		}
		
	}
	
}
