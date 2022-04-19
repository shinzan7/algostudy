package SW_expert.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_9229_한빈이와SpotMart {
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	static int T, N, M; // T 테스트케이스, N 과자봉지 개수, M 무게 합 제한
	static int maxWeight; // 최대 무게
	static int[] snacks;
	static int[] chosen = new int[2]; // 2개 선택

	public static void main(String[] args) throws IOException {
		// input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());

		for (int t = 1; t <= T; t++) {
			maxWeight = 0;
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());

			snacks = new int[N];
			tokens = new StringTokenizer(input.readLine());
			for (int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(tokens.nextToken());
			} // 과자 무게 입력완료

			combination(0, 0);

			if (maxWeight == 0)
				System.out.println("#" + t + " -1");
			else
				System.out.println("#" + t + " " + maxWeight);
		} // T.C
	}// main

	public static void combination(int cnt, int start) { //nC2

		if (cnt == 2) {
			int temp = chosen[0] + chosen[1];
			if (temp <= M && temp > maxWeight)
				maxWeight = temp;
			return;
		}

		for (int i = start; i < N; i++) {
			chosen[cnt] = snacks[i];
			combination(cnt + 1, i + 1);
		}

	}

}
