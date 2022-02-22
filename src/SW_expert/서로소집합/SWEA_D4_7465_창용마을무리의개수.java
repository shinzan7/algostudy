package SW_expert.서로소집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_D4_7465_창용마을무리의개수 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, M;
	static int people[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sb.append("#").append(t).append(" ");
			makeSet();
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			for (int i = 1; i <= N; i++) {
				findSet(i);
			}
			
			Set<Integer> set = new HashSet<Integer>();
			for (int i = 1; i <= N; i++) {
				set.add(people[i]);
			}
			sb.append(set.size()).append("\n");
			
		}//T.C
		System.out.println(sb);
		
	}//main
	
	public static void makeSet() {
		people = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			people[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(people[a]==a) return a;
		return people[a] = findSet(people[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		people[bRoot] = aRoot;
		
		return true;
	}

}
