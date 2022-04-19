package backjoon.최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_G4_1922_네트워크연결 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, repres[];
	static Edge[] edges;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		edges = new Edge[M];
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges[m] = new Edge(from, to, cost);
		}
		
		Arrays.sort(edges);
		repres = new int[N + 1];
		for (int i = 0; i < repres.length; i++) {
			repres[i] = i;
		}
		
		int result = 0;
		for (int i = 0, cnt = 0; i < M && cnt<N-1; i++) {
			if(union(edges[i].from, edges[i].to)) {
				result += edges[i].cost;
				cnt++;
			}
		}
		
		System.out.println(result);

	}
	
	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return false;
		repres[a] = b;
		return true;
	}
	
	private static int find(int a) {
		if(repres[a] == a) return a;
		return repres[a] = find(repres[a]);
	}
	
	private static class Edge implements Comparable<Edge>{
		int from, to ,cost;

		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
		
	}
	
	static String src = "6\r\n" + 
			"9\r\n" + 
			"1 2 5\r\n" + 
			"1 3 4\r\n" + 
			"2 3 2\r\n" + 
			"2 4 7\r\n" + 
			"3 4 6\r\n" + 
			"3 5 11\r\n" + 
			"4 5 3\r\n" + 
			"4 6 8\r\n" + 
			"5 6 8";
	
}
