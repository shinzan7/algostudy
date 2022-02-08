package SW_expert;

import java.util.Scanner;

public class SWEA_D2_1954_달팽이숫자 {
	public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for(int t=0; t<T; t++) {
			int N = scan.nextInt();
			int num = 1;
			int r = 0;
			int c = 0;
			
			int[][] snail = new int[N][N];
			
			while(num<=N*N) {
				if(c<N-1 && snail[r][c+1]==0) {
					if(r>0 && snail[r-1][c]==0) {
						snail[r--][c] = num++;
					}else {
						snail[r][c++] = num++;
					}
				}else if(r<N-1 && snail[r+1][c]==0) {
					snail[r++][c] = num++;
				}else if(c>0 && snail[r][c-1]==0) {
					snail[r][c--] = num++;
				}else if(r>0 && snail[r-1][c]==0) {
					snail[r--][c] = num++;
				}else {
					snail[r][c] = num++;
				}
			}
			
			System.out.println("#"+(t+1));
			for (int[] is : snail) {
				for (int i : is) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
			
			
		}// T.C
		
			
		scan.close();
		
	}
}