package backjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_1535_안녕 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		int[][] greet = new int[N+1][2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			greet[i][0] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			greet[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		int[][] arr = new int[N+1][100];
		for (int r = 1; r <= N; r++) {
			for (int c = 0; c < 100; c++) {
				if(greet[r][0] <= c) {
					arr[r][c] = Math.max(arr[r-1][c - greet[r][0]] + greet[r][1], arr[r-1][c]);
				}else {
					arr[r][c] = arr[r-1][c];
				}
				
			}
		}
		System.out.println(arr[N][99]);
		
	}
	
	static String src = "12\r\n" + 
			"1 1 1 1 1 1 1 1 1 1 1 1\r\n" + 
			"100 100 100 100 100 100 100 100 100 100 100 100";
	
}
