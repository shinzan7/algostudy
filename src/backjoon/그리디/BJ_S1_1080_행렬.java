package backjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_1080_행렬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R,C, count;
	static int[][] A, B, diff;
	
	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		A = new int[R][C];
		B = new int[R][C];
		diff = new int[R][C];
		count = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				A[r][c] = br.read()-'0';
			}
			br.readLine();
		}
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				B[r][c] = br.read()-'0';
			}
			br.readLine();
		}
		br.close();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(A[r][c] != B[r][c]) diff[r][c] = 1;
			}
		}
		
		out: while(true) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					
					//3x3 바꾸기
					if(diff[r][c]==1 && r+2<R && c+2<C) {
						for (int sr = r; sr <= r+2; sr++) {
							for (int sc = c; sc <= c+2; sc++) {
								if(diff[sr][sc]==1) diff[sr][sc] = 0;
								else diff[sr][sc] = 1;
							}
						}
						count++;
						//모두 바꿨으면 다시탐색
						r = 0;
						c = 0;
						continue out;
					}
					
				}
			}//변경 더이상 안되면	
			break;
		}
		outer : for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(diff[i][j]==1) {
					count = -1;
					break outer;
				}
			}
		}
		
		System.out.println(count);
		
	}

	
	
//	static String src = "3 4\r\n" + 
//			"0000\r\n" + 
//			"0010\r\n" + 
//			"0000\r\n" + 
//			"1001\r\n" + 
//			"1011\r\n" + 
//			"1001";
	
}
