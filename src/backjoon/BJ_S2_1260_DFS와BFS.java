package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_1260_DFS와BFS {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static int N,M,V, map[][];
	private static boolean visited[];
	
	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()) + 1; //정점의 개수+1
		M = Integer.parseInt(st.nextToken()); //간선의 개수
		V = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점의 번호
		
		map = new int[N][N];
		visited = new boolean[N];
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			map[start][end] = 1;
			map[end][start] = 1;
			
		}
		br.close();//입력완료
		
		DFS(V);
		visited = new boolean[N];
		System.out.println();
		BFS();
		
	}//main
	
	public static void DFS(int n) {
		visited[n] = true;
		System.out.print(n + " ");
		
		for (int i = 1; i < map.length; i++) {
			if(map[n][i] == 1 && !(visited[i])) {
				DFS(i);
			}
		}
		
	}
	
	private static void BFS() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(V);
		visited[V] = true;
		System.out.print(V + " ");
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for (int i = 1; i < map.length; i++) {
				if(map[temp][i] == 1 && !(visited[i])) {
					queue.offer(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
		
	}
	
	
//	private static String src = "1000 1 1000\r\n" + 
//			"999 1000";
}
