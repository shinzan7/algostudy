package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author shinz
 * @since 2022. 2. 16.
 * @see https://www.acmicpc.net/problem/1992
 * @performance 14152 KB 128 ms
 * @category 분할정복
 */
public class BJ_S1_1992_쿼드트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] deltas = {{0,0},{0,1},{1,0},{1,1}}; //1234분면
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = br.read() - '0';
			}
			br.readLine();
		}

		tree(0,0,N);

		System.out.println(sb);
	}
	
	private static void tree(int r, int c, int size) {
		
		if(isSame(r, c, size)) {
			sb.append(map[r][c]);
			return;
		}
		
		sb.append("(");
		
		for (int i = 0; i < deltas.length; i++) {
			int dr = r + (size/2) * deltas[i][0];
			int dc = c + (size/2) * deltas[i][1];
			
			tree(dr,dc,size/2);
		}
		
		
		sb.append(")");
		
		return;
	}
	
	private static boolean isSame(int sr, int sc, int size) {
		
		for (int r = sr; r < sr+size; r++) {
			for (int c = sc; c < sc+size; c++) {
				if(map[r][c]!=map[sr][sc]) return false;
			}
		}
		
		return true;
	}
	
}
