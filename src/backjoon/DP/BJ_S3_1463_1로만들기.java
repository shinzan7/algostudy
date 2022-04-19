package backjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_1463_1로만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
//		int n = 10;
		int[] A = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			if(i >= 1 && A[i-1] + 1 < min) min = A[i-1] + 1;
			if(i >= 2 && i%2 == 0 && A[i/2] + 1 < min) min = A[i/2] + 1;
			if(i >= 3 && i%3 == 0 && A[i/3] + 1 < min) min = A[i/3] + 1;
			
			A[i] = min;
		}
		System.out.println(A[n]);
	}
	
}
