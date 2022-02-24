package backjoon.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author shinz
 * @since 2022. 2. 17.
 * @see 
 * @performance
 * @category 백트래킹
 */
public class BJ_G2_3109_빵집 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C;
	static char[][] map;
	static int[] deltas = {-1, 0, 1};
	static int[] route;
	static int count;
	static boolean isEnd;
	
	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char [R][C];
		count = 0;
		route = new int[C]; //C이동하는동안 r의 정보
		
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		br.close(); //입력완료
		
		for (int i = 0; i < R; i++) {
			backtrack(i, 0);
		}
		System.out.println(count);

	}
	
	public static boolean backtrack(int r, int c) {

		for (int i = 0; i < deltas.length; i++) {
			int nr = r + deltas[i];
			int nc = c + 1;
			
			if(nr>=0 && nr<R && map[nr][nc]=='.') {
				if(nc == C-1) {
					count++;
					map[nr][nc] = '-';
					return true;
				}
				map[nr][nc] = '-';
				if(backtrack(nr, nc)) return true;
			}
			
		}
		return false;
		
	}
	
	
//	static String src = "6 10\r\n" + 
//			"..x.......\r\n" + 
//			".....x....\r\n" + 
//			".x....x...\r\n" + 
//			"...x...xx.\r\n" + 
//			"..........\r\n" + 
//			"....x.....";
	
}
