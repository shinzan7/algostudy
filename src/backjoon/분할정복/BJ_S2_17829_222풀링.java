package backjoon.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_17829_222풀링 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		int start[][] = map.clone(); //변환시작
		int result[][] = new int[N/2][N/2]; //변환결과
		int sort[] = new int[4];

		while(true) {
			if(result.length==1) break;
			result = new int[start.length / 2][start.length / 2];
			
			for (int r = 0; r < start.length; r += 2) {
				for (int c = 0; c < start.length; c += 2) {
					sort[0] = start[r][c];
					sort[1] = start[r+1][c];
					sort[2] = start[r][c+1];
					sort[3] = start[r+1][c+1];
					Arrays.sort(sort);
					result[r/2][c/2] = sort[2];
				}
			}
			start = result.clone();
		}
		System.out.println(result[0][0]);
		
	}//main
	
	
//	static String src = "8\r\n" + 
//			"-1 2 14 7 4 -5 8 9\r\n" + 
//			"10 6 23 2 -1 -1 7 11\r\n" + 
//			"9 3 5 -2 4 4 6 6\r\n" + 
//			"7 15 0 8 21 20 6 6\r\n" + 
//			"19 8 12 -8 4 5 2 9\r\n" + 
//			"1 2 3 4 5 6 7 8\r\n" + 
//			"9 10 11 12 13 14 15 16\r\n" + 
//			"17 18 19 20 21 22 23 24";
	
}
