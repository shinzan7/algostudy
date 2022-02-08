package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P16926_배열돌리기 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int R = scan.nextInt();
		
		int [][] nums = new int[N][M];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				nums[r][c] = scan.nextInt();
			}
		}
		scan.close();
		
		for(int i=0; i<R; i++) {
			nums = rotateArr(nums);
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				System.out.print(nums[r][c]+" ");
			}
			System.out.println();
		}
		
	}
	
	public static int[][] rotateArr(int [][] nums){
		
		int n = nums.length;
		int m = nums[0].length;
		
		int [][] temp = new int[n][m];
		
		int rIndex = 0;
		int cIndex = 0;
		
		while(n > 1 && m > 1) { // NM 1이하일때까지 반복
			//temp[0][0 ~ M-2]
			for(int i = cIndex; i<m+cIndex-1; i++) {
				temp[rIndex][i] = nums[rIndex][i+1];
			}
			
			//temp[0 ~ N-2][M-1]
			for(int i = rIndex; i<n+rIndex-1; i++) {
				temp[i][m+cIndex-1] = nums[i+1][m+cIndex-1];
			}
			
			//temp[N-1][1 ~ M-1]
			for(int i = 1+cIndex; i<m+cIndex; i++) {
				temp[n-1+rIndex][i] = nums[n-1+rIndex][i-1];
			}
			
			//temp[1 ~ N-1][0]
			for(int i = rIndex + 1; i<n+rIndex; i++) {
				temp[i][cIndex] = nums[i-1][cIndex];
			}
			
			n -= 2;
			m -= 2;
			rIndex++;
			cIndex++;
					
		}
		
		return temp;
	}

}
