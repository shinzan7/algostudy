package backjoon.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_S3_1406_에디터 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new StringReader(src));
		Deque<Character> l = new ArrayDeque<Character>();
		Deque<Character> r = new ArrayDeque<Character>();
		String origin = br.readLine();
		for (int i = 0; i < origin.length(); i++) {
			l.addLast(origin.charAt(i));
		}
		int M = Integer.parseInt(br.readLine()); //명령어 개수
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			if(order.equals("L")) {
				if(l.size()==0) continue;
				r.addFirst(l.pollLast());
			}else if(order.equals("D")) {
				if(r.size()==0) continue;
				l.addLast(r.pollFirst());
			}else if(order.equals("B")) {
				if(l.size()==0) continue;
				l.removeLast();
			}else {
				l.addLast(st.nextToken().charAt(0));
			}
			
		}
		while(!l.isEmpty()) {
			sb.append(l.pollFirst());
		}
		while(!r.isEmpty()) {
			sb.append(r.pollFirst());
		}
		System.out.println(sb);
	}
	
	static String src = "dmih\r\n" + 
			"11\r\n" + 
			"B\r\n" + 
			"B\r\n" + 
			"P x\r\n" + 
			"L\r\n" + 
			"B\r\n" + 
			"B\r\n" + 
			"B\r\n" + 
			"P y\r\n" + 
			"D\r\n" + 
			"D\r\n" + 
			"P z";
	
}
