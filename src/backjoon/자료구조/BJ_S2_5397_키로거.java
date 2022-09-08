package backjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ_S2_5397_키로거 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		br = new BufferedReader(new StringReader(src));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			//커서의 위치를 deque 2개로 구현한다
			Deque<Character> left = new ArrayDeque<>();
			Deque<Character> right = new ArrayDeque<>();
			
			String input = br.readLine();
			
			for (int i = 0; i < input.length(); i++) {
				char order = input.charAt(i); //명령어
				
				if(order=='<') {
					if(left.size()!=0) {
						right.addFirst(left.pollLast());
					}
					
				}else if(order=='>') {
					if(right.size()!=0) {
						left.addLast(right.pollFirst());
					}
					
				}else if(order=='-') {
						left.pollLast();
					
				}else {
					left.addLast(order);
				}

			}//명령어 처리완료
			
			while(!left.isEmpty()) {
				sb.append(left.pollFirst());
			}
			while(!right.isEmpty()) {
				sb.append(right.pollFirst());
			}
			
			sb.append("\n");
			
		}//T.C
		
		System.out.println(sb);
		
	}//main
	
//	static String src = "2\r\n" + 
//			"<<BP<A>>Cd-\r\n" + 
//			"ThIsIsS3Cr3t";

}
