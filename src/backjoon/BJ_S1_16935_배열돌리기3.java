package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_16935_배열돌리기3 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static int[][] map, temp;
	private static int R, C, howMany;

	public static void main(String[] args) throws IOException {
		//br = new BufferedReader(new StringReader(src));

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		howMany = Integer.parseInt(st.nextToken()); // 연산해야되는 숫자

		map = new int[R][C];

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// int calNum = Integer.parseInt(br.readLine()); // 연산종류
		st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			int calNum = Integer.parseInt(st.nextToken());

			rotateArr(calNum);
		}

		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}

	}

	private static void rotateArr(int num) {

		int halfR = map.length / 2;
		int halfC = map[0].length / 2;
		
		int RR = map.length;
		int CC = map[0].length;
		
		int tR = map[0].length;
		int tC = map.length;

		switch (num) {
		case 1:

			temp = new int[RR][CC];
			for (int r = 0; r < RR; r++) {
				temp[RR - 1 - r] = map[r];
			}
			map = temp.clone();

			break;

		case 2:

			temp = new int[RR][CC];
			for (int r = 0; r < RR; r++) {
				for (int c = 0; c < CC; c++) {
					temp[r][CC - 1 - c] = map[r][c];
				}
			}
			map = temp.clone();

			break;

		case 3:

			temp = new int[tR][tC];

			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map[0].length; c++) {
					temp[c][tC - 1 - r] = map[r][c];
				}
			}

			map = temp.clone();

			break;

		case 4:

			temp = new int[tR][tC];

			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map[0].length; c++) {
					temp[tR - 1 - c][r] = map[r][c];
				}
			}

			map = temp.clone();

			break;
		case 5:
			temp = new int[map.length][map[0].length];

			for (int r = 0; r < halfR; r++) { // 좌상
				for (int c = 0; c < halfC; c++) {
					temp[r][c + halfC] = map[r][c];
				}
			}

			for (int r = 0; r < halfR; r++) { // 우상
				for (int c = halfC; c < map[0].length; c++) {
					temp[r + halfR][c] = map[r][c];
				}
			}

			for (int r = halfR; r < map.length; r++) { // 우하
				for (int c = halfC; c < map[0].length; c++) {
					temp[r][c - halfC] = map[r][c];
				}
			}

			for (int r = halfR; r < map.length; r++) { // 우좌
				for (int c = 0; c < halfC; c++) {
					temp[r - halfR][c] = map[r][c];
				}
			}

			map = temp.clone();

			break;
		case 6:
			temp = new int[map.length][map[0].length];

			for (int r = 0; r < halfR; r++) { // 좌상
				for (int c = 0; c < halfC; c++) {
					temp[r + halfR][c] = map[r][c];
				}
			}

			for (int r = 0; r < halfR; r++) { // 우상
				for (int c = halfC; c < map[0].length; c++) {
					temp[r][c - halfC] = map[r][c];
				}
			}

			for (int r = halfR; r < map.length; r++) { // 우하
				for (int c = halfC; c < map[0].length; c++) {
					temp[r - halfR][c] = map[r][c];
				}
			}

			for (int r = halfR; r < map.length; r++) { // 우좌
				for (int c = 0; c < halfC; c++) {
					temp[r][c + halfC] = map[r][c];
				}
			}

			map = temp.clone();

			break;
		}

	}

//	private static String src = "6 8 6\r\n" + 
//			"3 2 6 3 1 2 9 7\r\n" + 
//			"9 7 8 2 1 4 5 3\r\n" + 
//			"5 9 2 1 9 6 1 8\r\n" + 
//			"2 1 3 8 6 3 9 2\r\n" + 
//			"1 3 2 8 7 9 2 1\r\n" + 
//			"4 5 1 9 8 2 1 3\r\n" + 
//			"1 2 3 5 6";
}
