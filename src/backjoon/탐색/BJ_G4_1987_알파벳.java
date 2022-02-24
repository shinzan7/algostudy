package backjoon.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_1987_알파벳 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C, max;
	static char[][] map;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean[] visited = new boolean[26];
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		max = 1;
		
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}

		
		backtrack(0, 0, 0);
		System.out.println(max);
		
	}//main
	
	
	public static void backtrack(int r, int c, int cnt) {
		//범위밖에 있거나 이미 포함된 알파벳이면
		if(visited[map[r][c] - 'A']) {
			if(max < cnt) max = cnt;
			return;
		}else {
			visited[map[r][c] - 'A'] = true;		
			
			//움직임 시도
			for (int i = 0; i < deltas.length; i++) {
				int sr = r + deltas[i][0];
				int sc = c + deltas[i][1];
				
				if(sr>=0 && sr<R && sc>=0 && sc<C) {
					backtrack(sr, sc, cnt+1);				
				}
			}
			visited[map[r][c] - 'A'] = false;	
		}
		
	}
	
	static String src = "10 10\r\n" + 
			"ASWERHGCFH\r\n" + 
			"QWERHDLKDG\r\n" + 
			"ZKFOWOHKRK\r\n" + 
			"SALTPWOKSS\r\n" + 
			"BMDLKLKDKF\r\n" + 
			"ALSKEMFLFQ\r\n" + 
			"GMHMBPTIYU\r\n" + 
			"DMNKJZKQLF\r\n" + 
			"HKFKGLKEOL\r\n" + 
			"OTOJKNKRMW";
}
