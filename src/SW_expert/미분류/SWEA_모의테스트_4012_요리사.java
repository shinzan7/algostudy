package SW_expert.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author shinz
 * @since 2022. 2. 16.
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AX5LR3N6iOoDFAX1&contestProbId=AWIeUtVakTMDFAVH&probBoxId=AX71HJlaULgDFAW0&type=PROBLEM&problemBoxTitle=2%EC%9B%94+3%EC%A3%BC&problemBoxCnt=3
 * @performance 22,868 kb 227 ms
 * @category 조합
 */

public class SWEA_모의테스트_4012_요리사 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T,N,result, map[][];
	static boolean[] isSelected; //재료인덱스
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			result = Integer.MAX_VALUE;
			isSelected = new boolean[N];
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			//N개중에 N/2개를 골라서 배열을 만들고 모두 합한 결과 result
			
			comb(0, 0);
			
			sb.append("#"+t+" "+result+"\n");
			
		}//T.C
		
		System.out.print(sb);
	}//main
	
	public static void makeFood() {
		int sumA = 0;
		int sumB = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(isSelected[r] && isSelected[c]) {
					sumA += map[r][c];
				}else if(!isSelected[r] && !isSelected[c]) {
					sumB += map[r][c];
				}
			}
		}
		if(Math.abs(sumA - sumB) < result) result = Math.abs(sumA - sumB);
		
	}
	
	public static void comb(int cnt, int start) { //조합만들기
		
		if (cnt == N/2) {
			makeFood();
			return;
		}
		
		for (int i = start; i < N; i++) {
				isSelected[i] = true;
				comb(cnt+1, i+1);
				isSelected[i] = false;
		}
		
	}
	
}
