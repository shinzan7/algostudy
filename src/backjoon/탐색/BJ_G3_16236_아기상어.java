package backjoon.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_16236_아기상어 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, map[][];
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	static int time = 0;
	static PriorityQueue<Fish> fishes = new PriorityQueue<Fish>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		Shark baby = null;
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int a = Integer.parseInt(st.nextToken());
				if(a==9) {
					map[r][c] = 0;
					baby = new Shark(r, c, 2, 2);
				}
				else map[r][c] = a;
			}
		}
		br.close();
		bfs(baby);
		System.out.println(time);
	}
	
	static void bfs(Shark shark) {
		Queue<Shark> q = new LinkedList<Shark>();
		boolean[][] visit = new boolean[N][N];
		
		q.offer(shark);
		visit[shark.r][shark.c] = true;
		int depth = 0;
		
			while(!q.isEmpty()) {
				int size = q.size();
				while(size-- > 0) {
					Shark current = q.poll();
					
					for (int i = 0; i < 4; i++) {
						int nr = current.r + deltas[i][0];
						int nc = current.c + deltas[i][1];
						
						//이동가능할 경우
						if(isIn(nr, nc) && !visit[nr][nc] && current.size >= map[nr][nc]) {
							//먹을 수 있는 경우
							if(map[nr][nc] > 0 && current.size > map[nr][nc]) {
								//후보 추가
								q.offer(new Shark(nr, nc, current.size, current.eatCnt));	
								visit[nr][nc] = true;
								fishes.offer(new Fish(nr, nc, map[nr][nc], depth + 1));
							}
							//이동만 가능한 경우
							else {
								q.offer(new Shark(nr, nc, current.size, current.eatCnt));	
								visit[nr][nc] = true;
							}
						}
					}
					
				}//한턴종료
				if(!fishes.isEmpty()) {
					break;
				}
				depth++;
				
			}//bfs종료
		if(fishes.isEmpty()) return;
		
		shark.eat(fishes.poll());
		fishes.clear();
		bfs(new Shark(shark.r, shark.c, shark.size, shark.eatCnt));
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
	
	
	static class Fish implements Comparable<Fish>{
		int r, c, size, distance;

		public Fish(int r, int c, int size, int distance) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "Fish [r=" + r + ", c=" + c + ", size=" + size + "]";
		}
		
		@Override
		public int compareTo(Fish o) {
			if(this.distance == o.distance) {
				if(this.r == o.r) {
					return Integer.compare(this.c, o.c);
				}else {
					return Integer.compare(this.r, o.r);
				}
				
			}else {
				return Integer.compare(this.distance, o.distance);
			}
		}
		
	}
	
	static class Shark{
		int r, c, size, eatCnt;
		
		public Shark(int r, int c, int size, int eatCnt) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.eatCnt = eatCnt;
		}

		public void eat(Fish f) {
			this.r = f.r;
			this.c = f.c;
			if(--eatCnt == 0) {
				size++;
				eatCnt = size;
			}
			time += f.distance;
			map[f.r][f.c] = 0;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", size=" + size + ", eatCnt=" + eatCnt + "]";
		}
		
	}
	
	static String src = "6\r\n" + 
			"1 1 1 1 1 1\r\n" + 
			"2 2 6 2 2 3\r\n" + 
			"2 2 5 2 2 3\r\n" + 
			"2 2 2 4 6 3\r\n" + 
			"0 0 0 0 0 6\r\n" + 
			"0 0 0 0 0 9";
	
}
