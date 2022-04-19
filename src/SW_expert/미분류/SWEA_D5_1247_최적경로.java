package SW_expert.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D5_1247_최적경로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, minDistance;
	static int[][] clients;
	static int[] home, company;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			clients = new int [N][2]; //고객들의 좌표정보
			isVisited = new boolean[N];
			home = new int[2]; //집 좌표
			company = new int[2]; //회사 좌표
			minDistance = Integer.MAX_VALUE;
			
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				clients[i][0] = Integer.parseInt(st.nextToken());
				clients[i][1] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0, new int[N]);
			
			sb.append("#").append(t).append(" ").append(minDistance);
			sb.append("\n");

		}// T.C
		
		System.out.println(sb);
		
	}// main
	
	private static void permutation(int cnt, int[] chosed) {
		
		if(cnt == N) {
			int sum = 0;
			sum += distance(company, clients[chosed[0]]); //회사와 첫번째 고객과의 거리 더하기
			
			for (int i = 0; i < N-1; i++) {
				sum += distance(clients[chosed[i]], clients[chosed[i+1]]); //고객 사이들 거리 더하기
			}
			
			sum += distance(clients[chosed[N-1]], home); //마지막 고객과 집과의 거리 더하기
			
			if(minDistance > sum) minDistance = sum; //최솟값 갱신 
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				chosed[cnt] = i;
				permutation(cnt+1, chosed);
				isVisited[i] = false;
			}
		}
		
	}
	
	private static int distance(int[] a, int[] b) { //a b사이의 거리 구하기
		return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
	}
	
}
