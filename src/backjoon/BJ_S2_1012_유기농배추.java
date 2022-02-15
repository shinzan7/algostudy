package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_1012_유기농배추 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int T;
	static int R, C, K; //가로세로 길이, K 배추 개수
	static int X, Y;// 배추 좌표
	static int[][] map;
	static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}}; //상하좌우
	static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//br = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			count = 0;
			map = new int[R][C];
			
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				Y = Integer.parseInt(st.nextToken());
				X = Integer.parseInt(st.nextToken());
				map[X][Y] = 1;
			}
			//입력완료
			
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(map[r][c] == 1) {
						dfs(r, c);
						count++;
					}
				}
			}
			System.out.println(count);
			
		}//T.C
		
	}//main
	
	public static void dfs(int r, int c) {
		map[r][c] = -1;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			
			if(nr>=0 && nr<R && nc>=0 && nc<C) { //가려는 곳이 map 내부일때
				if(map[nr][nc]==1) { //가려는 곳이 1이면
					dfs(nr, nc);
				}
			}
		}
		
	}

//	public static String src = "1\r\n" + 
//			"5 3 6\r\n" + 
//			"0 2\r\n" + 
//			"1 2\r\n" + 
//			"2 2\r\n" + 
//			"3 2\r\n" + 
//			"4 2\r\n" + 
//			"4 0";
}
