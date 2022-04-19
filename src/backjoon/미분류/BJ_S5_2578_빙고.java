package backjoon.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S5_2578_빙고 {
	private static int[][] map = new int[5][5];
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static int tryNum = 0;
	
	public static void main(String[] args) throws IOException {

		
		for (int r = 0; r < 5; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 5; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		//사회자 번호
		out: for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				tryNum++;
				int num = Integer.parseInt(st.nextToken());
				check(num);
				
				if(isBingo()) {
					System.out.println(tryNum);
					break out;
				}
			}
		}
		
	}
	//호명숫자 --> 0
	private static void check(int n) {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map.length; c++) {
				if(map[r][c] == n) {
					map[r][c] = 0;
					return;
				}
			}
		}
	}
	
	
	//빙고 판단메서드
	private static boolean isBingo() {
		if(tryNum<12) return false;
		
		int count = 0;
		
		for (int i = 0; i < 5; i++) {
			if(map[i][i]!=0) break;
			if(i==4) count++;
		}
		
		for (int i = 0; i < 5; i++) {
			if(map[i][4-i]!=0) break;
			if(i==4) count++;
		}
		
		for (int r = 0; r < 5; r++) {
			if(count == 3) return true;
			for (int c = 0; c < 5; c++) {
				if(map[r][c]!=0) break;
				if(c==4) count++;
			}
		}
		
		for (int c = 0; c < 5; c++) {
			if(count == 3) return true;
			for (int r = 0; r < 5; r++) {
				if(map[r][c]!=0) break;
				if(r==4) count++;
			}
		}
		
		return false;
	}
	
}
