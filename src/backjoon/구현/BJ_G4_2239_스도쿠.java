package backjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_2239_스도쿠 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int map[][];
	static int maxR, maxC;
	static boolean isEnd;

	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new StringReader(src));
		map = new int[9][9];
		for (int r = 0; r < 9; r++) {
			String str = br.readLine();
			for (int c = 0; c < 9; c++) {
				int temp = str.charAt(c) - '0';
				map[r][c] = temp;
			}
		}
		br.close();
		
		dfs(0);
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				sb.append(map[r][c]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cnt) {
		if(isEnd) return;
		if(cnt == 81) {
			isEnd = true;
			return;
		}
		
		int r = cnt/9;
		int c = cnt%9;
		maxR = Math.max(r, maxR);
		maxC = Math.max(c, maxC);
		
		if(map[r][c] != 0) { //빈칸이 아니면
			dfs(cnt+1);
			if(isEnd) return;
		}else { //빈칸이면
			boolean nums[] = check(r, c);		
			for (int i = 1; i < 10; i++) {
				if(!nums[i]) {
					map[r][c] = i;
					dfs(cnt+1);
					if(isEnd) return;
					map[r][c] = 0;
				}
			}
		}
		
	}

	private static boolean[] check(int cr, int cc) {
		boolean[] result = new boolean[10]; // false 들어갈 수 있는 숫자
		result[0] = true;
		for (int r = 0; r < 9; r++) {
			result[map[r][cc]] = true;
		}
		for (int c = 0; c < 9; c++) {
			result[map[cr][c]] = true;
		}
		// box 구분
		int startR = boxStartIdx(cr);
		int startC = boxStartIdx(cc);
		for (int r = startR; r < startR+3; r++) {
			for (int c = startC; c < startC+3; c++) {
				result[map[r][c]] = true;
			}
		}
		
		return result;
	}

	private static int boxStartIdx(int n) { // box start index 리턴
		if (n <= 2) {
			return 0;
		} else if (n <= 5) {
			return 3;
		} else {
			return 6;
		}
	}

//	static String src = "103000509\r\n" + "002109400\r\n" + "000704000\r\n" + "300502006\r\n" + "060000050\r\n"
//			+ "700803004\r\n" + "000401000\r\n" + "009205800\r\n" + "804000107";

}
