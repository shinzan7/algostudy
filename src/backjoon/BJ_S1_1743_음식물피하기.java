package backjoon;

import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;

public class BJ_S1_1743_음식물피하기 {
	
	static int R, C, K;
	static int[][] map;
	static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}}; //상하좌우
	static int max = 0;
	static int count;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//scan = new Scanner(new StringReader(src));
		
		R = scan.nextInt();
		C = scan.nextInt();
		K = scan.nextInt();
		int r,c;
		
		map = new int[R][C];
		
		for (int k = 0; k < K; k++) {
			r = scan.nextInt() - 1;
			c = scan.nextInt() - 1;
			map[r][c] = 1;
		}
		scan.close();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 1) {
					count = 0;
					dfs(i, j);
				}
			}
		}
		System.out.println(max);
	}
	
	static void dfs(int r, int c) {
		map[r][c] = -1;
		count++;
		
		if(max < count) max = count;
		
		for (int i = 0; i < 4; i++) {
			int sr = r + deltas[i][0];
			int sc = c + deltas[i][1];
			if(sr>=0 && sr<R && sc>=0 && sc<C && map[sr][sc] == 1) {
					dfs(sr, sc);					
			}
		}
		
		
	}
	
//	static String src = "3 4 5\r\n" + 
//			"3 2\r\n" + 
//			"2 2\r\n" + 
//			"3 1\r\n" + 
//			"2 3\r\n" + 
//			"1 1";
}
