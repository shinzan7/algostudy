package backjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_S3_1072_게임 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
//		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		long X = Integer.parseInt(st.nextToken());
		long Y = Integer.parseInt(st.nextToken());
		
		int answer = -1;
		int pct = (int) (Y * 100 / X);
		if(pct < 99 && pct>=0) {
			answer = (int) Math.ceil(((pct + 1) * X - 100 * Y) / (99.0 - pct));
		}
		
		System.out.println(answer);
		
	}
	
//	static String src = "1000000000 470000000";
	
}
