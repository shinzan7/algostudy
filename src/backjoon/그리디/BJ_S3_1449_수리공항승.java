package backjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_1449_수리공항승 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, L, leak[];
	
	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //물이 새는 곳의 개수
		L = Integer.parseInt(st.nextToken()); //테이프의 길이
		leak = new int[N]; //물이 새는 위치
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			leak[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		Arrays.sort(leak);
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			count++;
			int left = L; //남은 테이프 길이
			while(i<N) {
				if(i+1<N && leak[i+1]-leak[i]<left) {
					left -= leak[i+1] - leak[i];
					i++;
				}else {
					break;
				}
			}
		}
		System.out.println(count);
		
		
	}//main

	
}
