package backjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G5_2493_탑 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
//		br = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Column> stack = new Stack<>();
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		//첫째 기둥
		stack.add(new Column(n, 1));
		sb.append("0 ");
		
		//둘째 기둥부터
		for (int i = 2; i <= N; i++) {
			n = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty() && stack.peek().num < n) {
				//비어있지 않고 자신보다 낮으면 pop하고 다음으로
				stack.pop();
			}
			
			//비었다면
			if(stack.isEmpty()) {
				sb.append("0 ");
				stack.add(new Column(n, i));
			}else {
				//안비었고 자신보다 높은 기둥이 있으면 sb에 추가하고 stack추가
				sb.append(stack.peek().idx).append(" ");
				stack.add(new Column(n, i));
			}
			
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);

	}
	
	static class Column {
		int num, idx;

		public Column(int num, int idx) {
			super();
			this.num = num;
			this.idx = idx;
		}
		
	}
	
//	static String src = "6\r\n" + 
//			"6 5 4 3 2 1";
	
}
