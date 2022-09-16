package backjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G5_6198_옥상정원꾸미기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
//		br = new BufferedReader(new StringReader(src));
		
		
		Long N = Long.parseLong(br.readLine());
		Stack<Long> stack = new Stack<>();
		
		Long sum = 0L;
		
		for (int i = 0; i < N; i++) {
			Long n = Long.parseLong(br.readLine());
			
			//n보다 높은 기둥이 나올때까지 pop
			while(!stack.isEmpty() && stack.peek() <= n) {
				stack.pop();
			}
			
			sum += stack.size();
			stack.add(n);
			
		}
		
		System.out.println(sum);

	}
	
//	static String src = "6\r\n" + 
//			"10\r\n" + 
//			"3\r\n" + 
//			"7\r\n" + 
//			"4\r\n" + 
//			"12\r\n" + 
//			"2";
	
}
