package SW_expert.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_D4_3124_최소스패닝트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int V, E;
	static Node[] edges;
	static int[] repres;
	public static void main(String[] args) throws IOException{
//		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); //정점의 개수
			E = Integer.parseInt(st.nextToken()); //간선의 개수
			edges = new Node[E];
			
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				edges[e] = new Node(from, to, cost);
			}
			Arrays.sort(edges);
			
			repres = new int[V+1];
			for (int i = 1; i < repres.length; i++) {
				repres[i] = i;
			}
			
			long cost = 0;
			
			for (int i = 0, cnt = 0; i < E && cnt < V-1; i++) {
				Node edge = edges[i];
				if(union(edge.from, edge.to)) {
					cost += edge.cost;
					cnt++;
				}
			}
			
			sb.append("#").append(t);
			sb.append(" ").append(cost).append("\n");
		}// T.C
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
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
	
	private static class Node implements Comparable<Node>{
		int from, to, cost;

		public Node(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}
		
		
		
	}
	
//	static String src = "2\r\n" + 
//			"3 3\r\n" + 
//			"1 2 1\r\n" + 
//			"2 3 2\r\n" + 
//			"1 3 3\r\n" + 
//			"5 7\r\n" + 
//			"1 2 4\r\n" + 
//			"1 3 3\r\n" + 
//			"1 4 9\r\n" + 
//			"2 4 3\r\n" + 
//			"2 5 1\r\n" + 
//			"3 4 5\r\n" + 
//			"4 5 2";
	
}
