package backjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S2_1874_스택수열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
//		br = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		
		Queue<Integer> q = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		while(cnt != N) {
			if(stack.isEmpty() && !q.isEmpty()) {
				sb.append("+").append("\n");
				stack.add(q.poll());				
			}
			if(!stack.isEmpty() && arr[cnt] == stack.peek()) {
				sb.append("-").append("\n");
				stack.pop();
				cnt++;
				continue;
			}else if(!q.isEmpty()){
				sb.append("+").append("\n");
				stack.add(q.poll());
			}else {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
			
		}
		
		System.out.println(sb);

	}
	
//	static String src = "5\r\n" + 
//			"1\r\n" + 
//			"2\r\n" + 
//			"5\r\n" + 
//			"3\r\n" + 
//			"4";
	
}
