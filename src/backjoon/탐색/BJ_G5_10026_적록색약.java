package backjoon.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_G5_10026_적록색약 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static char map[][];
	static int deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = (char)br.read();
			}
			br.readLine();
		}
		br.close(); //입력완료
		
		int count = 0;
		visit = new boolean[N][N];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visit[r][c]) {
					dfs(r, c);
					count++;
				}
			}
		}
		sb.append(count).append(" ");
		count = 0;
		visit = new boolean[N][N];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c]=='R') map[r][c] = 'G';
			}
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visit[r][c]) {
					dfs(r, c);
					count++;
				}
			}
		}
		sb.append(count);
		
		System.out.println(sb);
		
	}
	
	public static void dfs(int r, int c) {
		visit[r][c] = true;
		char color = map[r][c];
		
		for (int i = 0; i < deltas.length; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			
			if(!isIn(nr, nc)) continue;
			
			if(color == map[nr][nc] && !visit[nr][nc]) {
				dfs(nr, nc);
			}
		}
		
	}
	
	public static boolean isIn(int r, int c) {
		return (r>=0 && r<N && c>=0 && c<N);
	}
//	
//	static String src = "5\r\n" + 
//			"RRRBB\r\n" + 
//			"GGBBB\r\n" + 
//			"BBBRR\r\n" + 
//			"BBRRR\r\n" + 
//			"RRRRR";
//	
}
