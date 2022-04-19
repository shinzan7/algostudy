package backjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_17135_캐슬디펜스 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R,C,D,map[][],count, originMap[][], maxCount;
	static int deltas[][] = {{0,-1},{-1,0},{0,1}}; //좌 상 우
	public static void main(String[] args) throws IOException{
//		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken()); //궁수 사정거리
		map = new int [R][C];
		originMap = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				int n = Integer.parseInt(st.nextToken());
				map[r][c] = n;
				originMap[r][c] = n;
			}
		}
		br.close();
		maxCount = 0;
		
		comb(0, 0, new int[3]);
		
		System.out.println(maxCount);
		
	}
	
	static void comb(int cnt, int start, int[] arr) { //3자리 뽑기
		if(cnt == 3) {
			
			copyOrigin(map, originMap);
			count = 0;
			for (int i = 0; i < R; i++) {
				attack(arr);
				move();			
			}
			maxCount = Math.max(count, maxCount);

			
			return;
		}
		
		for (int i = start; i < C; i++) {
			arr[cnt] = i;
			comb(cnt+1, i+1, arr);
		}
		
	}
	
	static void copyOrigin(int[][] map, int[][] originMap){
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				map[r][c] = originMap[r][c];
			}
		}
	}
	
	static void move() { //한칸씩 아래로 이동 적이 성에 닿으면 false
		for (int c = 0; c < C; c++) {			
			for (int r = R-1; r > 0; r--) { //끝에서 0번 행까지 아래로 내리기
				map[r][c] = map[r-1][c];
			}
			map[0][c] = 0; //첫번째 행 0으로 설정
		}
	}
	
	static void attack(int[] arrowers) { //궁수인덱스 배열
		
		List<Point> targets = new LinkedList<>();
		
		next: for (int i = 0; i < 3; i++) { //3명 목표 탐색
			Queue<Point> q = new LinkedList<>();
			int idx = arrowers[i];
			boolean[][] visit = new boolean[R][C]; //bfs 방문배열
			q.add(new Point(R-1, idx));
			visit[R-1][idx] = true;
			int range = D;
			
			if(range > 1) {
				while(!q.isEmpty()) {
					int size = q.size();
					while(size-- > 0) {
						Point cur = q.poll();
						if(map[cur.r][cur.c] == 1) {
							targets.add(new Point(cur.r, cur.c)); //궁수 i 타겟설정완료
							continue next;
						}
						
						for (int j = 0; j < 3; j++) { //좌상우 3방향 탐색
							int nr = cur.r + deltas[j][0];
							int nc = cur.c + deltas[j][1];
							if(nr>=0 && nr<R && nc>=0 && nc<C && !visit[nr][nc]) {
								q.add(new Point(nr, nc));
								visit[nr][nc] = true;
							}
						}
						
					}//범위 한칸 넓히기
					range--;
					if(range == 0) {
						break;
					}
				}
			}else {
				if(map[R-1][idx]==1) targets.add(new Point(R-1, idx));
			}
			
		}//궁수123 타겟설정완료
		
		//일제사격
		
		for (Point t : targets) {
			if(map[t.r][t.c] == 1) {
				map[t.r][t.c] = 0;
				count++;
			}
		}
		
	}
	
	private static class Point{
		int r,c;

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
	
	static String src = "6 5 2\r\n" + 
			"1 0 1 0 1\r\n" + 
			"0 1 0 1 0\r\n" + 
			"1 1 0 0 0\r\n" + 
			"0 0 0 1 1\r\n" + 
			"1 1 0 1 1\r\n" + 
			"0 0 1 0 0";
	
}
