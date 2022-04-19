package SW_expert.미분류;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D4_9760_pokerGame {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static Card[] cards;

	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new FileReader("input.txt"));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			cards = new Card[5];
			for (int i = 0; i < 5; i++) {
				String str = st.nextToken();
				char rank = str.charAt(1);
				int rk = 0;
				if (rank == 'A')
					rk = 1;
				else if (rank == 'T')
					rk = 10;
				else if (rank == 'J')
					rk = 11;
				else if (rank == 'Q')
					rk = 12;
				else if (rank == 'K')
					rk = 13;
				else
					rk = rank - '0';
				cards[i] = new Card(str.charAt(0), rk);
			}

			Arrays.sort(cards);
			String ans = check();

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		} // TC

		System.out.println(sb);
	}

	private static String check() {
		// 1
		if (isSeveral(0, 5) && isSameSute(0, 5)) {
			return "Straight Flush";
		} else if (isSameSute(0, 5) && isSeveral(1, 4) && cards[0].rank == 1) {
			return "Straight Flush";
		}
		// 2
		else if (isSame(0, 4) || isSame(1, 4)) {
			return "Four of a Kind";
		}
		// 3
		else if ((isSame(0, 2) && isSame(2, 3)) || (isSame(0, 3) && isSame(3, 2))) {
			return "Full House";
		}
		// 4
		else if (isSameSute(0, 5)) {
			return "Flush";
		}
		// 5
		else if (isSeveral(0, 5)) {
			return "Straight";
		}
		// 6
		else if (isSame(0, 3) || isSame(1, 3) || isSame(2, 3)) {
			return "Three of a kind";
		}
		// 7
		else if (isSame(0, 2) && isSame(2, 2) || isSame(0, 2) && isSame(3, 2) || isSame(1, 2) && isSame(3, 2)) {
			return "Two pair";
		}
		// 8
		else if (isSame(0, 2) || isSame(1, 2) || isSame(2, 2) || isSame(3, 2)) {
			return "One pair";
		}

		return "High card";
	}

	private static boolean isSameSute(int i, int cnt) {
		for (int j = i + 1; j < i + cnt; j++) {
			if (cards[j].sute != cards[j - 1].sute)
				return false;
		}
		return true;
	}

	private static boolean isSame(int i, int cnt) {
		for (int j = i + 1; j < i + cnt; j++) {
			if (cards[j].rank - cards[j - 1].rank != 0)
				return false;
		}
		return true;
	}

	private static boolean isSeveral(int i, int cnt) {
		for (int j = i + 1; j < i + cnt; j++) {
			if (cards[j].rank - cards[j - 1].rank != 1)
				return false;
		}
		return true;
	}

	private static class Card implements Comparable<Card> {
		char sute;
		int rank;

		public Card(char sute, int rank) {
			super();
			this.sute = sute;
			this.rank = rank;
		}

		@Override
		public String toString() {
			return "[" + sute + ", " + rank + "]";
		}

		@Override
		public int compareTo(Card o) {
			if (this.rank != o.rank) {
				return this.rank - o.rank;
			}
			return (this.sute - 'A') - (o.sute - 'A');
		}

	}

}
