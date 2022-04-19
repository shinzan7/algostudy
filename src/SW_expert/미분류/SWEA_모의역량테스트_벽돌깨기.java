package SW_expert.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_모의역량테스트_벽돌깨기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, C, R, minRemain, map[][], REMAIN;
	static int[][] deltas = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new StringReader(src));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 떨어뜨린 구슬의 개수
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			int remain = 0;
			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					int num = Integer.parseInt(st.nextToken());
					map[r][c] = num;
					if (num > 0)
						remain++;
				}
			} // 입력완료
			REMAIN = remain; // 초기 남은 수
			minRemain = remain; // 남은 최소의 벽돌 수

			dfs2(0, new int[N]);

//			for (int[] m : map) {
//				System.out.println(Arrays.toString(m));
//			}

			sb.append("#").append(t).append(" ");
			sb.append(minRemain).append("\n");

		} // T.C
		System.out.println(sb);

	}// main

	private static void dfs2(int cnt, int[] arr) {
		if (cnt == arr.length) {
			int[][] cloneMap = new int[R][C];
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					cloneMap[r][c] = map[r][c];
				}
			}

			int remain = 0;

			for (int i = 0; i < arr.length; i++) {
				breakStone(arr[i], cloneMap);
			}
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (cloneMap[r][c] > 0)
						remain++;
				}
			}

			minRemain = Math.min(remain, minRemain);

			return;
		}

		for (int i = 0; i < C; i++) {
			arr[cnt] = i;
			dfs2(cnt + 1, arr);
		}

	}

	private static void breakStone(int sc, int[][] map) { // 부수는 열 위치, 현재 남은 벽돌 수
		int sr = -1;
		int num = 0;
		for (int r = 0; r < R; r++) {
			if (map[r][sc] > 0) {
				sr = r;
				num = map[r][sc];
				break;
			}
		}
		if (sr == -1)
			return; // 부술 것이 없으면
		// 부술 것이 있으면
		Queue<Stone> q = new LinkedList<>();
		q.offer(new Stone(sr, sc, num));

		while (!q.isEmpty()) {
			Stone cur = q.poll();
			if (cur.n == 0)
				continue;
			else if (cur.n == 1) { // 벽돌 1
				map[cur.r][cur.c] = 0;
				continue;
			} else { // 벽돌 2이상
				map[cur.r][cur.c] = 0;
				dir: for (int i = 0; i < 4; i++) { // 4방향
					for (int l = 1; l < cur.n; l++) { // 폭발시키는 길이 l
						int nr = cur.r + deltas[i][0] * l;
						int nc = cur.c + deltas[i][1] * l;

						if (!(nr >= 0 && nr < R && nc >= 0 && nc < C))
							continue dir;
						// 안쪽이면
						if (map[nr][nc] > 1) {
							q.offer(new Stone(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;
					}
				}

			}

		} // 부수기 완료

		// 정렬하면서 remain 세기
		for (int c = 0; c < C; c++) {
			int[] temp = new int[R]; // 복사할 행렬
			for (int r = R - 1, idx = R - 1; r >= 0; r--) { // 아래에서부터 쌓기
				if (map[r][c] > 0) {
					temp[idx--] = map[r][c];
				}
			}
			for (int r = 0; r < R; r++) { // 복사한 행렬로 덮어쓰기
				map[r][c] = temp[r];
			}
		}
		return;
	}

	private static class Stone {
		int r, c, n;

		public Stone(int r, int c, int n) {
			super();
			this.r = r;
			this.c = c;
			this.n = n;
		}

	}

	static String src = "5\r\n" + "3 10 10\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n" + "1 0 1 0 1 0 0 0 0 0\r\n"
			+ "1 0 3 0 1 1 0 0 0 1\r\n" + "1 1 1 0 1 2 0 0 0 9\r\n" + "1 1 4 0 1 1 0 0 1 1\r\n"
			+ "1 1 4 1 1 1 2 1 1 1\r\n" + "1 1 5 1 1 1 1 2 1 1\r\n" + "1 1 6 1 1 1 1 1 2 1\r\n"
			+ "1 1 1 1 1 1 1 1 1 5\r\n" + "1 1 7 1 1 1 1 1 1 1\r\n" + "2 9 10\r\n" + "0 0 0 0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0 0 0 0\r\n" + "0 1 0 0 0 0 0 0 0\r\n" + "0 1 0 0 0 0 0 0 0\r\n" + "1 1 0 0 1 0 0 0 0\r\n"
			+ "1 1 0 1 1 1 0 1 0\r\n" + "1 1 0 1 1 1 0 1 0\r\n" + "1 1 1 1 1 1 1 1 0\r\n" + "1 1 3 1 6 1 1 1 1\r\n"
			+ "1 1 1 1 1 1 1 1 1\r\n" + "3 6 7\r\n" + "1 1 0 0 0 0\r\n" + "1 1 0 0 1 0\r\n" + "1 1 0 0 4 0\r\n"
			+ "4 1 0 0 1 0\r\n" + "1 5 1 0 1 6\r\n" + "1 2 8 1 1 6\r\n" + "1 1 1 9 2 1\r\n" + "4 4 15\r\n"
			+ "0 0 0 0 \r\n" + "0 0 0 0 \r\n" + "0 0 0 0 \r\n" + "1 0 0 0 \r\n" + "1 0 0 0 \r\n" + "1 0 0 0 \r\n"
			+ "1 0 0 0 \r\n" + "1 0 5 0 \r\n" + "1 1 1 0 \r\n" + "1 1 1 9 \r\n" + "1 1 1 1 \r\n" + "1 6 1 2 \r\n"
			+ "1 1 1 5 \r\n" + "1 1 1 1 \r\n" + "2 1 1 2 \r\n" + "4 12 15\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9";

}
