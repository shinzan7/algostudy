package backjoon.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_2491_수열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, nums[], maxLength;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		maxLength = 1;
		
		if(N>1) {
			int cnt = 1; 
			for (int i = 1; i < N; i++) {//오름차순
				if(nums[i] >= nums[i-1]) {
					cnt++;
				}else {
					maxLength = Math.max(cnt, maxLength);
					cnt = 1;
				}
				maxLength = Math.max(cnt, maxLength);
			}
			cnt = 1;
			for (int i = 1; i < N; i++) {//내림차순
				if(nums[i] <= nums[i-1]) {
					cnt++;
				}else {
					maxLength = Math.max(cnt, maxLength);
					cnt = 1;
				}
				maxLength = Math.max(cnt, maxLength);
			}
		}
		System.out.println(maxLength);
		
	}
	
//	static String src = "5\r\n" + 
//			"1 1 1 1 1";
	
}
