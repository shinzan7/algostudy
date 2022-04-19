package backjoon.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_G4_4485_녹색옷입은애가젤다지 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[][] deltas = {{0,1},{1,0},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new StringReader(src));
		int t = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			int[][] map = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}//입력완료
			sb.append("Problem ").append(t++).append(": ");
			sb.append(daik(map)).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);

	}
	
	static int daik(int[][] map) {
		int[][] distance = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);			
		}
		distance[0][0] = map[0][0];
		distance[0][1] = map[0][1];
		distance[1][0] = map[1][0];
		boolean[][] visit = new boolean[N][N];
		
		visit[0][0] = true;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int min = Integer.MAX_VALUE;
				int cr = 0;
				int cc = 0;
				
				for (int tr = 0; tr < N; tr++) {
					for (int tc = 0; tc < N; tc++) {
						if(!visit[tr][tc] && distance[tr][tc] < min) {
							min = distance[tr][tc];
							cr = tr;
							cc = tc;
						}						
					}
				}
				visit[cr][cc] = true;
				distance[cr][cc] = min;
				
				for (int i = 0; i < 4; i++) {
					int nr = cr + deltas[i][0];
					int nc = cc + deltas[i][1];
					
					if(nr>=0 && nr<N && nc>=0 && nc<N &&
							distance[nr][nc] > distance[cr][cc] + map[nr][nc]) {
						distance[nr][nc] = distance[cr][cc] + map[nr][nc];
					}
					
					
				}

			}
		}
		
		return distance[N-1][N-1] + map[0][0];
	}
	
	
	static String src = "3\r\n" + 
			"5 5 4\r\n" + 
			"3 9 1\r\n" + 
			"3 2 7\r\n" + 
			"5\r\n" + 
			"3 7 2 0 1\r\n" + 
			"2 8 0 9 1\r\n" + 
			"1 2 1 8 1\r\n" + 
			"9 8 9 2 0\r\n" + 
			"3 6 5 1 5\r\n" + 
			"7\r\n" + 
			"9 0 5 1 1 5 3\r\n" + 
			"4 1 2 1 6 5 3\r\n" + 
			"0 7 6 1 6 8 5\r\n" + 
			"1 1 7 8 3 2 3\r\n" + 
			"9 4 0 7 6 4 1\r\n" + 
			"5 8 3 2 4 8 3\r\n" + 
			"7 4 8 4 8 3 4\r\n" + 
			"0";
	
}
