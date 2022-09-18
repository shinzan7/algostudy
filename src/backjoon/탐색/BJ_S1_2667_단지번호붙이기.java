package backjoon.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_2667_단지번호붙이기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static List<Integer> houseNum = new ArrayList<>();
	static int N;
	static boolean isHouse[][], isVisit[][];
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		isHouse = new boolean[N][N];
		isVisit = new boolean[N][N];
		String str = "";
		int n = 0;
		
		for (int r = 0; r < N; r++) {
			str = br.readLine();
			for (int c = 0; c < N; c++) {
				n = str.charAt(c) - '0';
				if(n==1) {
					isHouse[r][c] = true;
				}
				
			}
		}
		//입력완료
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(isHouse[r][c] && !isVisit[r][c]) {
					houseNum.add(bfs(r,c));
					
				}
			}
		}
		Collections.sort(houseNum);
		sb.append(houseNum.size()).append("\n");
		for (int i = 0; i < houseNum.size(); i++) {
			sb.append(houseNum.get(i)).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static boolean isIn(int r, int c) {
		return (r>=0 && r<N && c>=0 && c<N);
	}	
	
	private static Integer bfs(int r, int c) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(r, c));
		isVisit[r][c] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			cnt++;
			
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + deltas[i][0];
				int nc = cur.c + deltas[i][1];
				
				if(isIn(nr, nc) && isHouse[nr][nc] && !isVisit[nr][nc]) {
					q.add(new Point(nr, nc));
					isVisit[nr][nc] = true;
				}
				
			}
		}
		
		return cnt;
	}


	static String src = ""
			+ "7\r\n" + 
			"0110100\r\n" + 
			"0110101\r\n" + 
			"1110101\r\n" + 
			"0000111\r\n" + 
			"0100000\r\n" + 
			"0111110\r\n" + 
			"0111000";

}
