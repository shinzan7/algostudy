package backjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S4_10773_제로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException{
//		br = new BufferedReader(new StringReader(src));
		
		Stack<Integer> stack = new Stack<>();
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n!=0) {
				stack.add(n);				
			}else {
				stack.pop();
			}
		}
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);

	}

//	static String src = "10\r\n" + 
//			"1\r\n" + 
//			"3\r\n" + 
//			"5\r\n" + 
//			"4\r\n" + 
//			"0\r\n" + 
//			"0\r\n" + 
//			"7\r\n" + 
//			"0\r\n" + 
//			"0\r\n" + 
//			"6";
	
}
