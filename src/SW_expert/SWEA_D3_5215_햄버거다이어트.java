package SW_expert;

import java.util.Scanner;

public class SWEA_D3_5215_햄버거다이어트 {

	static int T, N, L, maxScore;
	static int[] score, cal;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();

		for (int t = 0; t < T; t++) {
			N = scan.nextInt(); // 재료의 수
			L = scan.nextInt(); // 제한 칼로리
			maxScore = 0;

			score = new int[N];
			cal = new int[N];

			for (int i = 0; i < N; i++) {
				score[i] = scan.nextInt();
				cal[i] = scan.nextInt();
			}
			// 입력완료
			
			makeBurger(0, 0, 0);
			System.out.println("#" + (t + 1) + " " + maxScore);

		} // T.C

	}// main

	public static void makeBurger(int cnt, int sc, int ca) {
		if (ca > L) return;

		if (cnt == N) {
			if (maxScore < sc) maxScore = sc;

			return;
		}
		makeBurger(cnt + 1, sc + score[cnt], ca + cal[cnt]);
		makeBurger(cnt + 1, sc, ca);
	}

}
