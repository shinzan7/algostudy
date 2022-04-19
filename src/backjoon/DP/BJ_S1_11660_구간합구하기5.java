package backjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_11660_구간합구하기5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, map[][];

	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 표의 크기
		M = Integer.parseInt(st.nextToken()); // 합을 구하는 횟수
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		if (N != 1) {		
			for (int r = 0; r < N; r++) {
				for (int c = 1; c < N; c++) {
					// 가로 누적합
					map[r][c] += map[r][c - 1];
				}
			}
			for (int r = 1; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 세로 누적합
					map[r][c] += map[r - 1][c];
				}
			}

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int x1 = Integer.parseInt(st.nextToken()) - 1;
				int y1 = Integer.parseInt(st.nextToken()) - 1;
				int x2 = Integer.parseInt(st.nextToken()) - 1;
				int y2 = Integer.parseInt(st.nextToken()) - 1;
				int result = 0;
				if(x1 == 0 && y1 == 0) {
					result = map[x2][y2];
				}
				else if(x1 == 0) {
					result = map[x2][y2] - map[x2][y1-1];
				}
				else if(y1 == 0) {
					result = map[x2][y2] - map[x1-1][y2];
				}
				else {
					result = map[x2][y2] - map[x2][y1-1] - map[x1-1][y2] + map[x1-1][y1-1];					
				}
				
				sb.append(result).append("\n");
			}
			System.out.println(sb);
		}else { //N = 1
			System.out.println(map[0][0]);
		}
	}

//	static String src = "4 3\r\n" + "1 2 3 4\r\n" + "2 3 4 5\r\n" + "3 4 5 6\r\n" + "4 5 6 7\r\n" + "2 2 3 4\r\n"
//			+ "3 4 3 4\r\n" + "1 1 4 4";

}
