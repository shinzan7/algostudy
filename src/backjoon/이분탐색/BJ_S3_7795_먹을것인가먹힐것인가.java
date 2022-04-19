package backjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S3_7795_먹을것인가먹힐것인가 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int result = 0;
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int[] a = new int[A];
			int[] b = new int[B];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < A; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < B; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}//입력완료
			Arrays.sort(a);
			Arrays.sort(b);
			
			for (int i = A-1; i >= 0; i--) {
				int current = a[i];
				
				if(current <= b[0]) break; //현재 A가 가장작은 B보다 작으면 더 이상 진행하지 않음
				for (int j = B-1; j >= 0; j--) {	
					if(current > b[j]) { // B가 A보다 작으면 그 이하는 전부 먹을수 있음
						result += j+1;
						break;
					}
				}
			}
			sb.append(result).append("\n");
			
		}//T.C
		System.out.println(sb);
	}
	
	static String src = "2\r\n" + 
			"5 3\r\n" + 
			"8 1 7 3 1\r\n" + 
			"3 6 1\r\n" + 
			"3 4\r\n" + 
			"2 13 7\r\n" + 
			"103 11 290 215";
	
}
