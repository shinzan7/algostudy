package SW_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_D4_1238_Contact {
	
	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			return "[v=" + vertex + ", l=" + link + "]";
		}
	}
	static int length, startVertex, maxNum;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int t = 1;
		
		String str = br.readLine();
		while(str != null) {
			sb.append("#").append(t++).append(" ");
			
			st = new StringTokenizer(str);
			length = Integer.parseInt(st.nextToken())/2;
			startVertex = Integer.parseInt(st.nextToken());
			
			Node[] adjList = new Node[101];
			maxNum = 0; //최대번호 초기화
			//length개의 노드
			st = new StringTokenizer(br.readLine()); 
			for (int i = 0; i < length; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adjList[from] = new Node(to, adjList[from]);
			}
			bfs(adjList, startVertex);
			sb.append(maxNum);
			
			
			str = br.readLine();
			sb.append("\n");
		}//T.C
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		
	}//main
	
	static void bfs(Node[] adjList, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[101];
		int depth[] = new int [101];
		int maxDepth = 1;
		
		queue.offer(start);
		visited[start] = true;
		depth[start] = 1;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(Node temp = adjList[current]; temp!=null; temp = temp.link) {
				if(!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
					depth[temp.vertex] = depth[current] + 1;
				}
			}
		}
		for (int i = 0; i < depth.length; i++) {
			if(maxDepth <= depth[i]) {
				maxDepth = depth[i];
				maxNum = i;
			} 
		}

	}
	

}
