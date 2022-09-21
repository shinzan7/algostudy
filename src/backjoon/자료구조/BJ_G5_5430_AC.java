package backjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_G5_5430_AC {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new StringReader(src));
		
		int T = Integer.parseInt(br.readLine());
		
		testcase: for (int t = 0; t < T; t++) {
			Deque<Integer> origin = new ArrayDeque<>();
			Deque<Integer> reverse = new ArrayDeque<>();
			boolean isOrigin = true;

			String order = br.readLine();
			int length = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[,]");
			
			while(st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				origin.add(n);
				reverse.addLast(n);
			}
			
			for (int i = 0; i < order.length(); i++) {
				if(order.charAt(i) == 'R') {
					isOrigin = !isOrigin;
				}else {
					if(origin.isEmpty()) {
						sb.append("error").append("\n");
						continue testcase;
					}else {
						if(isOrigin) { //origin 처음, reverse 마지막
							origin.pollFirst();
							reverse.pollLast();
						}else { //origin 마지막, reverse 처음
							origin.pollLast();
							reverse.pollFirst();
						}
					}
					
				}
				
			}
			
			if(!isOrigin) {
				origin = inversion(origin);
			}
			
			sb.append("[");
			
			if(!origin.isEmpty()) {
				while(!origin.isEmpty()) {
					sb.append(origin.pollFirst()).append(",");
				}
				sb.setLength(sb.length()-1);				
			}
			
			sb.append("]").append("\n");

		}
		System.out.println(sb);

	}//main
	
	static Deque<Integer> inversion(Deque<Integer> origin){
		Deque<Integer> reverse = new ArrayDeque<>();
		while(!origin.isEmpty()) {
			reverse.add(origin.pollLast());
		}
		
		return reverse;
	}
	
	static String src = "1\r\n" + 
			"R\r\n" + 
			"0\r\n" + 
			"[]";
	
}
