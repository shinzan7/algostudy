package backjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_1244_스위치켜고끄기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, arr[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine()); //스위치 개수 + 1
		st = new StringTokenizer(br.readLine());
		arr = new int [N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int studentNum = Integer.parseInt(br.readLine()); // 학생수
		for (int i = 0; i < studentNum; i++) {
			//스위치 조작
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			if(gender==1) boy(number);
			else girl(number);
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(arr[i]).append(" ");
			if(i>=20 && i%20==0) {
				sb.append("\n");
			}
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	static void boy(int n) {
		int original = n;
		while(n <= N) {
			change(n);
			n += original;
		}
	}
	
	static void girl(int n) {
		change(n);
		int i = 1;
		//범위 안일때까지 반복
		while(n-i>=1 && n+i<=N) { 
			//대칭이 아니면 그만
			if(arr[n-i] != arr[n+i]) break;
			//대칭이면
			change(n-i);
			change(n+i);
			i++;
		}
	}
	
	static void change(int n) {
		if(arr[n]==0) arr[n] = 1;
		else arr[n] = 0;
	}
	
//	static String src = "10\r\n" + 
//			"0 1 0 1 0 0 0 1 0 1 \r\n" + 
//			"2\r\n" + 
//			"1 3\r\n" + 
//			"2 3";
	
}
