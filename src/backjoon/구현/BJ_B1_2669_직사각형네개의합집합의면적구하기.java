package backjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B1_2669_직사각형네개의합집합의면적구하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map = new int[100][100];
	
	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new StringReader(src));
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int ldx = Integer.parseInt(st.nextToken())-1;
			int ldy = Integer.parseInt(st.nextToken())-1;
			int rux = Integer.parseInt(st.nextToken())-1;
			int ruy = Integer.parseInt(st.nextToken())-1;
			
			for (int r = ldx; r < rux; r++) {
				for (int c = ldy; c < ruy; c++) {
					map[r][c] = 1;
				}
			}
		}
		int count = 0;
		
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if(map[r][c]==1) count++;
			}
		}
		System.out.print(count);
	}
	
//	static String src = "1 2 4 4\r\n" + 
//			"2 3 5 7\r\n" + 
//			"3 1 6 5\r\n" + 
//			"7 3 8 6";
	
}
