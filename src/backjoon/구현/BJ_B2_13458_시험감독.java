package backjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B2_13458_시험감독 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, B, C, student[];
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		student = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			student[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		long result = N;
		for (int i = 0; i < N; i++) {
			student[i] -= B; //총감독관 만큼 빼기
			if(student[i] <= C && student[i] > 0) {
				result++;
			}else if(student[i] > C) {
				double add = Math.ceil((double)student[i] / (double)C); 
				
				result += (int) add;
			}
		}
		System.out.println(result);

	}

}
