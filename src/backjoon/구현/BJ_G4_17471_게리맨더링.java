package backjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_17471_게리맨더링 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, minDiff;
	static city[] graph;
	public static void main(String[] args) throws IOException{
//		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		graph = new city[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			graph[i] = new city(Integer.parseInt(st.nextToken()));
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			for (int j = 0; j < t; j++) {
				graph[i].adjCity.add(Integer.parseInt(st.nextToken()));
			}
		}
		br.close();
		minDiff = Integer.MAX_VALUE;

		comb(0, 0, 0);
		if(minDiff == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minDiff);
	}
	
	static void check(int flag) {
		Queue<city> q = new LinkedList<>();
		int sum1 = 0; //1그룹 합
		int[] visit = new int[N+1]; //1,2그룹 방문여부
		visit[0] = -1;
		for (int i = 0; i < N; i++) {
			if((flag & 1<<i) > 0) {
				q.offer(graph[i+1]);
				visit[i+1] = 1; //1그룹 방문
				sum1 += graph[i+1].p;
				break;
			}
		}
		
		//선택된 그룹 연결 체크
		while(!q.isEmpty()) {
			city cur = q.poll();
			for (int i = 0; i < cur.adjCity.size(); i++) {
				int next = cur.adjCity.get(i);
				if((flag & 1<<(next-1)) > 0 && visit[next] == 0) {
					q.offer(graph[next]);
					visit[next] = 1;
					sum1 += graph[next].p;
				}
			}
		}
		//선택되지 않은 그룹 연결 체크
		int sum2 = 0; //2그룹 합
		
		for (int i = 0; i < N; i++) {
			if((flag & 1<<i) == 0) {
				q.offer(graph[i+1]);
				visit[i+1] = 2; //2그룹 방문
				sum2 += graph[i+1].p;
				break;
			}
		}
		while(!q.isEmpty()) {
			city cur = q.poll();
			for (int i = 0; i < cur.adjCity.size(); i++) {
				int next = cur.adjCity.get(i);
				if((flag & 1<<(next-1)) == 0 && visit[next] == 0) {
					q.offer(graph[next]);
					visit[next] = 2;
					sum2 += graph[next].p;
				}
			}
		}
		//끊어진 도시검사
		for (int i = 0; i < visit.length; i++) {
			if(visit[i] == 0) return;
		}
		//둘다 연결되어있으면 최솟값 갱신
		int diff = Math.abs(sum1 - sum2);
		minDiff = Math.min(diff, minDiff);
	}
	
	static void comb(int cnt ,int flag, int start) {
		if(cnt == N && flag != 0 && flag !=63) {
			check(flag);
			return;
		}
		
		for (int i = start; i < N; i++) {
			comb(cnt+1, flag | 1<<i , i+1);
			comb(cnt+1, flag , i+1);
		}
		
	}
	
	static class city{
		int p; //인구
		List<Integer> adjCity = new ArrayList<Integer>();
		public city(int p) {
			super();
			this.p = p;
		}
		
	}
	
	
//	static String src = "5\r\n" + 
//			"5 2 3 4 1\r\n" + 
//			"1 2\r\n" + 
//			"4 1 3 5 4\r\n" + 
//			"1 2\r\n" + 
//			"1 2\r\n" + 
//			"1 2";
	
}
