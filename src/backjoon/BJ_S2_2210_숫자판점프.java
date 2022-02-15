package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_S2_2210_숫자판점프 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] map = new int[5][5];
	static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}}; //상하좌우
	static HashSet<String> set = new HashSet<String>();
	
	public static void main(String[] args) throws IOException {
		//br = new BufferedReader(new StringReader(src));
		
		for (int r = 0; r < 5; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 5; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		String nums = "";
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				dfs(r, c, nums);
			}
		}
		System.out.println(set.size());
	}
	
	public static void dfs(int r, int c, String str) {
		if(str.length()==6) {
			set.add(str);
			return;
		}
		
		str += map[r][c];
		
		for (int i = 0; i < deltas.length; i++) {
			int sr = r + deltas[i][0];
			int sc = c + deltas[i][1];
			if(sr>=0 && sr<5 && sc>=0 && sc<5) {
				dfs(sr, sc, str);
			}
			
		}
		
	}
	
	
//	static String src = "1 1 1 1 1\r\n" + 
//			"1 1 1 1 1\r\n" + 
//			"1 1 1 1 1\r\n" + 
//			"1 1 1 2 1\r\n" + 
//			"1 1 1 1 1";
}
