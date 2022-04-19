package SW_expert.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_D4_5643_prof키순서 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int count, N, M, map[][], bigNsmall[];
	public static void main(String[] args) throws IOException{
//		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); //학생의 수 (정점)
			M = Integer.parseInt(br.readLine()); //비교한 횟수 (간선)
			map = new int[N+1][N+1];
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = 1;
			}//입력완료
			count = 0;
			bigNsmall = new int[N+1];
			
			findBigger();
			findSmaller();
			
			for (int i = 1; i <= N; i++) {
				if(bigNsmall[i] == N - 1) {
					count++;
				}
			}
			
			sb.append("#").append(t).append(" ");
			sb.append(count).append("\n");
		}//T.C
		System.out.println(sb);

	}//main
	
	static void findBigger() {
		Queue<Integer> q = new LinkedList<>();
		for (int r = 1; r <= N; r++) { //학생 1부터
			boolean visit[] = new boolean[N+1];
			q.offer(r);
			visit[r] = true;
			int cnt = -1;
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				cnt++; //큰것을 뽑을때마다 카운트
				for (int c = 1; c <= N; c++) {
					if(!visit[c] && map[cur][c] == 1) {
						q.offer(c);
						visit[c] = true;
					}
				}
			}
			//학생 1 완료
			bigNsmall[r] += cnt;
		}
	}
	
	static void findSmaller() {
		Queue<Integer> q = new LinkedList<>();
		for (int c = 1; c <= N; c++) { //학생 1부터
			boolean visit[] = new boolean[N+1];
			q.offer(c);
			visit[c] = true;
			int cnt = -1;
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				cnt++; //큰것을 뽑을때마다 카운트
				for (int r = 1; r <= N; r++) {
					if(!visit[r] && map[r][cur] == 1) {
						q.offer(r);
						visit[r] = true;
					}
				}
			}
			//학생 1 완료
			bigNsmall[c] += cnt;
		}
	}
	
//	static String src = "1\r\n" + 
//			"6\r\n" + 
//			"6\r\n" + 
//			"1 5\r\n" + 
//			"3 4\r\n" + 
//			"5 4\r\n" + 
//			"4 2\r\n" + 
//			"4 6\r\n" + 
//			"5 2";
}
