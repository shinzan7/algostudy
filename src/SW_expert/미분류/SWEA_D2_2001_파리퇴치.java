package SW_expert.미분류;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_D2_2001_파리퇴치 {
	static int T,N,M;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		T = scan.nextInt();
		
		for(int t=0; t<T; t++) {
			N = scan.nextInt();
			M = scan.nextInt();
			map = new int[N][N];
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					map[r][c] = scan.nextInt();
				}
			}
			int ans = 0;
			
			for(int r=0; r<N-M+1; r++) { // 한곳씩 파리 죽여보기
				for(int c=0; c<N-M+1; c++) {
					
					int temp = 0;
					
					for(int mr=r; mr<=r+M-1; mr++) { // 파리채 mr, mc
						for(int mc=c; mc<=c+M-1; mc++) {
							temp += map[mr][mc];
						}
					}
					if(temp > ans) {
						ans = temp;
					}
				}
			}
			System.out.println("#"+(t+1)+" "+ans);
			
		}// T.C
		
	}//main
}