package SW_expert.미분류;

import java.io.StringReader;
import java.util.Scanner;

public class SWEA_D4_3289_서로소집합 {

	static StringBuilder sb = new StringBuilder();
	static int T, N, M;
	static int[] parents;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		Scanner scan = new Scanner(new StringReader(src));
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			M = scan.nextInt();
			
			sb.append("#").append(t).append(" ");
			makeSet();
			
			for (int m = 0; m < M; m++) {
				int calcul = scan.nextInt(); //연산 0 1
				if(calcul==0) {
					union(scan.nextInt(), scan.nextInt());
				}else {
					if(findSet(scan.nextInt()) == findSet(scan.nextInt())) {
						sb.append(1);
					}else sb.append(0);
				}
			}
			sb.append("\n");
			
		}//T.C
		
		System.out.println(sb);
	}//main
	
	static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot==bRoot) return false;
		
		parents[aRoot] = bRoot;
		return true;
	}
	
	static void makeSet() {
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
}
