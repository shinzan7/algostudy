package backjoon.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_1753_최단경로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V, E, START;
	
	static class Node{
		int to, weight;
		Node link;
		public Node(int vertex, int weight, Node link) {
			super();
			this.to = vertex;
			this.weight = weight;
			this.link = link;
		}
		@Override
		public String toString() {
			return "[v" + to + ", w" + weight + ", link=" + link + "]";
		}


	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()) + 1; //정점의 개수+1
		E = Integer.parseInt(st.nextToken()); //간선의 개수
		START = Integer.parseInt(br.readLine()); //시작위치
		
		Node[] nodeList = new Node[V];
		
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodeList[from] = new Node(to, weight, nodeList[from]);
		}
		
		int distance[] = new int[V];
		boolean[] visit = new boolean[V];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[START] = 0;
		
		for (int i = 1; i < V; i++) {
			// 단계1: 최소비용이 선택되지 않은 정점중 최소비용의 정점 선택
			int min = Integer.MAX_VALUE;
			int current = 0;
			for (int j = 1; j < V; j++) {
				if(!visit[j] && min>distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			visit[current] = true;
			
			// 단계2: 선택된 정점을 경유지로 다시탐색
//			for (int j = 0; j < V; j++) {
//				if(!visit[j] && map[current][j] != 0 && 
//						distance[j] > distance[current] + map[current][j]) {
//					distance[j] = distance[current] + map[current][j];
//				}
//			}
			for(Node temp = nodeList[current]; temp != null; temp=temp.link) {
				if(!visit[temp.to] && distance[temp.to] > distance[current] + temp.weight) {
					distance[temp.to] = distance[current] + temp.weight;
				}
			}
			
			
		}
	
		for (int i = 1; i < V; i++) {
			if(distance[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
			else sb.append(distance[i]).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
	
	
	
	
	static String src = "5 6\r\n" + 
			"1\r\n" + 
			"5 1 1\r\n" + 
			"1 2 2\r\n" + 
			"1 3 3\r\n" + 
			"2 3 4\r\n" + 
			"2 4 5\r\n" + 
			"3 4 6";
	
}
