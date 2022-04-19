package backjoon.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S3_2559_수열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K, temper[];
	
	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //전체 날짜의 수
		K = Integer.parseInt(st.nextToken()); //연속적인 날짜의 수
		
		temper = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			temper[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		int maxT = Integer.MIN_VALUE;
		for (int i = 0; i <= N-K; i++) {
			int temp = 0;
			for (int j = i; j < i+K; j++) {
				temp += temper[j];
			}
			maxT = Math.max(maxT, temp);
		}
		
		System.out.println(maxT);
	}
	
	
}
