package backjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_1149_RGB거리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, cost[][];
	public static void main(String[] args) throws IOException{
//		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine()); //집 개수
		cost = new int[N + 1][3]; //각 집의 rgb 비용
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		System.out.println(DP());

	}
	
	private static long DP() {
		long[][] dp = new long[N+1][3]; //각 최소 비용
		dp[1][0] = cost[1][0];
		dp[1][1] = cost[1][1];
		dp[1][2] = cost[1][2];
		
		for (int i = 2; i <= N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + cost[i][2];
		}
		long min = Math.min(dp[N][0], dp[N][1]); 
		min = Math.min(min, dp[N][2]); 
		
		return min;
	}
	
//	static String src = "8\r\n" + 
//			"71 39 44\r\n" + 
//			"32 83 55\r\n" + 
//			"51 37 63\r\n" + 
//			"89 29 100\r\n" + 
//			"83 58 11\r\n" + 
//			"65 13 15\r\n" + 
//			"47 25 29\r\n" + 
//			"60 66 19";
	
}
