package backjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S2_2304_창고다각형 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, result;
	static List<Column> list = new LinkedList<Column>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Column(x, y));
		}
		br.close();
		
		Column high = new Column(0, 0); //가장높은 기둥
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).y > high.y) {
				high = list.get(i);
			}
		}
		Collections.sort(list);
		
		Column big = new Column(0, 0); //현재까지의 큰 기둥
		
		//왼쪽부터 검색 
		for (int i = 0; i < list.size(); i++) {
			Column current = list.get(i);
			if(current.x == high.x) {
				result += (current.x - big.x) * big.y;
				break;	
			}
			
			if(big.y < current.y) {
				result += (current.x - big.x) * big.y;
				big = new Column(current.x, current.y);
			}
		}
		//가장높은기둥 넓이 더하기
		result += high.y;
		
		big = new Column(0, 0); //현재까지의 큰 기둥
		//오른쪽부터 검색
		for (int i = list.size()-1; i >= 0; i--) {
			Column current = list.get(i);
			if(current.x == high.x) {
				result += (big.x - current.x) * big.y;
				break;	
			}
			
			if(big.y < current.y) {
				result += (big.x - current.x) * big.y;
				big = new Column(current.x, current.y);
			}
		}
		
		System.out.println(result);
	}
	
	static class Column implements Comparable<Column>{
		int x, y;

		public Column(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}

		@Override
		public int compareTo(Column o) {
			return Integer.compare(this.x, o.x);
		}
		
	}
	
//	static String src = "7\r\n" + 
//			"2 4\r\n" + 
//			"11 9\r\n" + 
//			"15 8\r\n" + 
//			"4 6\r\n" + 
//			"5 3\r\n" + 
//			"8 10\r\n" + 
//			"13 6";
	
}
