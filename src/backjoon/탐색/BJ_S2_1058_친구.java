package backjoon.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_S2_1058_친구 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, max;
	static char[][] map;
	static boolean[] friend;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		max = 0;
		
		for (int r = 0; r < N; r++) {
			String line = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = line.charAt(c);
			}
		}
		br.close();
		
		bfs();
		System.out.println(max);
		
	}
	
	
	static void bfs() {
		for (int p = 0; p < N; p++) {
			friend = new boolean[N];
			Queue<Person> q = new LinkedList<Person>();
			q.offer(new Person(p, 0));
			friend[p] = true;
			int count = 0;
			
			while(!q.isEmpty()) {
				Person current = q.poll();
				
				for (int c = 0; c < N; c++) {
					//세지않았으면서 Y일때, 직접친구일때까지만 추가
					if(!friend[c] && map[current.index][c] == 'Y' &&
							current.depth < 2) {
						q.offer(new Person(c, current.depth + 1));
						friend[c] = true;
						count++;
					}
				}
			}//친구 모두 셈
			max = Math.max(max, count);
		}
	}
	
	static class Person{
		int index, depth;

		public Person(int index, int depth) {
			super();
			this.index = index;
			this.depth = depth;
		}
		
	}
	
}
