package backjoon.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_16926_배열돌리기1 {
	
	private static int R, C, rotateNum;
	private static int[][] map, temp;
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(input.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		rotateNum = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(input.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int t = 0; t<rotateNum; t++) {
			temp = new int[R][C];
			
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					switch(moveDir(r,c)) {
					case 1: //좌
						temp[r][c-1] = map[r][c];
						break;
					case 2: //우
						temp[r][c+1] = map[r][c];
						break;
					case 3: //하
						temp[r+1][c] = map[r][c];
						break;
					case 4: //상
						temp[r-1][c] = map[r][c];
						break;
					}
				}
			}
			map = temp.clone();
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		
		
	}//main
	
	private static int moveDir(int r, int c) {
		if(r+c<=C-1 && r<c && r<(R/2)) { //왼쪽
			return 1;
		}
		else if(r+c>=R-1 && r>=(R/2) && c-r<(C>R? R>C? R-C:C-R : R<C? R-C:C-R)) { // 오른쪽
			if(R%2==1 && r==R/2) return 0;
			return 2;
		}
		else if(r+c<R-1 && r>=c && c<(C/2)) { // 아래쪽
			return 3;
		}
		else if(r+c>C-1 && c>=(C/2) && c-r>=(R<C? R-C:C-R)) { // 위쪽
			if(C%2==1 && c==C/2) return 0;
			return 4;
		}
		
		return 0;
	}
	
//	private static String src = "4 4 2\r\n" + 
//			"1 2 3 4\r\n" + 
//			"5 6 7 8\r\n" + 
//			"9 10 11 12\r\n" + 
//			"13 14 15 16";

}
