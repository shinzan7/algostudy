package SW_expert;

import java.util.Scanner;

public class SWEA_D3_2805_농작물수확하기 {
	static int T, N;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		T = scan.nextInt();
		
		for(int t=0; t<T; t++) {
			N = scan.nextInt();
			map = new int[N][N];
			int midIndex = (N-1)/2;
			
			for(int r=0; r<N; r++) {
				String temp = scan.next();
				
				for(int c=0; c<N; c++) {
					map[r][c] = Character.getNumericValue(temp.charAt(c));
				}
			}
			
			int sum = 0;
			
			for(int ur=0; ur<midIndex; ur++) {// 중간 윗부분
				for(int uc=midIndex-ur; uc<=midIndex+ur; uc++) {
					sum += map[ur][uc];
				}
			}
			for(int mc=0; mc<N; mc++) { //중간 부분
				sum += map[midIndex][mc];
			}
			for(int dr=N-1; dr>midIndex; dr--) {
				for(int dc=midIndex-(N-1-dr); dc<=midIndex+(N-1-dr); dc++) {
					sum += map[dr][dc];
				}
			}
			
			System.out.println("#"+(t+1) +" " +sum);
			
		}// T.C
	}//main
}