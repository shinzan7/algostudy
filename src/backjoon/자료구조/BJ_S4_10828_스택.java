package backjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S4_10828_스택 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
//		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String order = st.nextToken();
			
			if(order.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			}else if(order.equals("pop")) {
				int temp = -1;
				//스택이 비어있지 않으면
				if(!stack.isEmpty()) {
					temp = stack.pop();
				}
				sb.append(temp).append("\n");
				
			}else if(order.equals("size")) {
				sb.append(stack.size()).append("\n");
			}else if(order.equals("empty")) {
				int temp = 0;
				if(stack.isEmpty()) {
					temp = 1;
				}
				sb.append(temp).append("\n");
			}else if(order.equals("top")) {
				int temp = -1;
				if(!stack.isEmpty()) {
					temp = stack.peek();
				}
				sb.append(temp).append("\n");
			}

		}
		
		System.out.println(sb);
		

	}
	
//	static String src = "7\r\n" + 
//			"pop\r\n" + 
//			"top\r\n" + 
//			"push 123\r\n" + 
//			"top\r\n" + 
//			"pop\r\n" + 
//			"top\r\n" + 
//			"pop";
	
}
