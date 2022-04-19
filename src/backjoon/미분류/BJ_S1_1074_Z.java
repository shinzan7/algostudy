package backjoon.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_1074_Z {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, R, C;
	
	public static void main(String[] args) throws IOException {
		//br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		br.close();
		
		z(N, 0);
		
	}//main
	
	public static void z(int n, int count) { //변 길이
		if(n==0) {
			System.out.println(count);
			return;
		}
		int N = n;
		
		//1234분면 판단
		if(R < 1<<N-1 && C < 1<<N-1) { // 1
			
		}else if(R < 1<<N-1 && C >= 1<<N-1) {// 2
			count += (1<<2*n-2);
			C -= (1<<n-1);
		}else if(R >= 1<<N-1 && C < 1<<N-1) {// 3
			count += (1<<2*n-2) * 2;
			R -= (1<<n-1);
		}else { // 4
			count += (1<<2*n-2) * 3;
			R -= (1<<n-1);
			C -= (1<<n-1);
		}
		n -= 1;
		z(n, count);
		
	}
	
	
	//public static String src = "10 512 512";
}
