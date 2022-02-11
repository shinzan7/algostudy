package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_16927_배열돌리기2 {
	
	private static int R, C, rotateNum;
	private static int[][] map;
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
		}//입력 완료
		
		int depth = ((R<C)? R : C)/2;
		
		for (int dep = 1; dep <= depth; dep++) {
			rotate(dep);
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}//입력 완료
		
	}//main
	
	private static void rotate(int d) {
		
		int boundary = (R-(d-1)*2)*2 + (C-(d-1)*2)*2 - 4;
		int toRotate = rotateNum % boundary; //회전해야 하는 수
		
		for (int i = 0; i < toRotate; i++) {
			
			int temp = map[d-1][d-1];
			
			for (int c = d; c <= C-d; c++) { //상
				map[d-1][c-1] = map[d-1][c];
			}
			for (int r = d; r <= R-d; r++) { //우
				map[r-1][C-d] = map[r][C-d];
			}
			for (int c = C-d-1; c >= d-1; c--) {// 하
				map[R-d][c+1] = map[R-d][c];
			}
			for (int r = R-d-1; r >= d; r--) { // 좌
				map[r+1][d-1] = map[r][d-1];
			}
			map[d][d-1] = temp;
		}
		
	}
	
	
//	private static String src = "2 2 3\r\n" + 
//			"1 1\r\n" + 
//			"1 1";

}
