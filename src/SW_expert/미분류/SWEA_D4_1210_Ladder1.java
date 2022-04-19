package SW_expert.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D4_1210_Ladder1 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int [][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//input = new BufferedReader(new StringReader(src));
		
		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(input.readLine());
			
			map = new int[100][100];
			
			for (int r = 0; r < 100; r++) {
				st = new StringTokenizer(input.readLine());
				for (int c = 0; c < 100; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			//입력완료
			int start = 0;
			
			for (int i = 0; i < 100; i++) {
				if(map[99][i]==2) {
					start = i;
					break;
				}
			}
			
			int r = 99;
			
			while(r>0) {
				if(start>0 && map[r][start-1]==1) {//왼쪽
					start--;
					while(map[r-1][start]==0) {
						start--;
					}
					r--;
					
				}else if(start<99 && map[r][start+1]==1) {//오른쪽
					start++;
					while(map[r+1][start]==0) {
						start++;
					}
					r--;
					
				}else {//위로
					r--;
				}
			}//도착
			
			
			System.out.println("#"+T+" "+ start);
			
		}//T.C

		
	}//main
	
}
