package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B1_10163_색종이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, maxR, maxC;
	static int map[][] = new int [1001][1001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		maxR = 0;
		maxC = 0;
		
		for (int t = 1; t <= N; t++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int dr = Integer.parseInt(st.nextToken());
			int dc = Integer.parseInt(st.nextToken());
			if(R+dr > maxR) maxR = R+dr;
			if(C+dc > maxC) maxC = C+dc;
			
			for (int r = R; r < R+dr; r++) {
				for (int c = C; c < C+dc; c++) {
					map[r][c] = t;
				}
			}
					
		}//map 입력완료
		int cntNum[] = new int[N+1];
		
		for (int r = 0; r < maxR; r++) {
			for (int c = 0; c < maxC; c++) {
				if(map[r][c] != 0) cntNum[map[r][c]]++;
			}
		}
		
		for (int i = 1; i < cntNum.length; i++) {
			sb.append(cntNum[i]).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
	
//	static String src = "4\r\n" + 
//			"0 2 10 10\r\n" + 
//			"7 9 8 4\r\n" + 
//			"8 4 10 6\r\n" + 
//			"6 0 12 10";
}
