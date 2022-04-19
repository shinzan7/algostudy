package SW_expert.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_prof_5604_구간합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static long A, B, result;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			result = 0;

			long add = 1; // 시작은 1의 자리
			while (A <= B) {
				// 시작과 끝을 0, 9로
				while(B%10 != 9 && A<=B) {
					eachNum(B, add);
					B--;
				}
				if (A > B) {
					break;					
				}
				while(A%10 != 0 && A<=B) {
					eachNum(A, add);
					A++;
				}
				
				// 10으로 나누기
				A /= 10;
				B /= 10;

				// 나누기몫 만큼 0~9 더하기 (1의자리 1, 10의 자리 10 곱하기)
				
				for (int i = 0; i < 10; i++) {
					result += ((B-A+1) * add)*i;
				}

				add *= 10;
			}

			sb.append("#").append(t).append(" ").append(result).append("\n");
		} // tc
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}// main

	private static void eachNum(long a, long add) { // 각 자리숫자 더하기
		while (a > 0) {
			result += (a%10) * add;
			a /= 10;
		}
	}

	static String src = "3\r\n" + "0 10\r\n" + "8 12\r\n" + "33 133";

}
