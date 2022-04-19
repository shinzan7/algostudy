package SW_expert.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_SWtest샘플문제_프로세서연결하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static List<Point> cores;
	static int N, map[][], minLine, maxCore;
	public static void main(String[] args) throws IOException{
//		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cores = new ArrayList<>();
			minLine = Integer.MAX_VALUE;
			
			int edgeCores = 0;
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					int num = Integer.parseInt(st.nextToken());
					if(num == 1) {
						map[r][c] = 1;
						if(r!=0 && r!=N-1 && c!=0 && c!=N-1) { //가장자리가 아니면
							cores.add(new Point(r, c));				
						}else {
							edgeCores++;
						}
					}
				}
			}//입력 완료
			maxCore = edgeCores;
			dfs(0, 0, edgeCores);
			
			sb.append("#").append(t).append(" ");
			sb.append(minLine).append("\n");
		}//T.C
		
		System.out.println(sb);

	}//main
	
	
	private static void dfs(int count, int idx, int coreCnt) {//core 카운트
		
//		if(coreCnt <= maxCore && count > minLine) return;
		if(maxCore > coreCnt + cores.size() - idx) return;
		
		if(idx == cores.size()) {
			if(coreCnt > maxCore) {
				minLine = count;
				maxCore = coreCnt;
			}else if(coreCnt == maxCore) {
				minLine = Math.min(minLine, count);
			}
			return;
		}
		
		Point core = cores.get(idx);
		for (int dir = 1, i = 0; dir <= 4; dir++) {
			if(core.checkLine(dir)) { //방향으로 깔 수 있으면
				count += core.changeLine(dir, 2);
				dfs(count, idx+1, coreCnt + 1);
				//원상복구
				count -= core.changeLine(dir, 0);
			}
//			else {	
//				i++; //연결못한 횟수
//			}
//			// 4방향 모두 못간다면
//			if(i == 4) dfs(count, idx+1, coreCnt);		
		}
		dfs(count, idx+1, coreCnt);
		
	}
	
	private static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		public int changeLine(int dir, int line) { //전선 깔기, 제거
			int cr = this.r;
			int cc = this.c;
			int count = 0;
			if(dir == 1) {//상
				while(--cr >= 0) {
					map[cr][cc] = line;
					count++;
				}
			}else if(dir == 2) {//하
				while(++cr < N) {
					map[cr][cc] = line;
					count++;
				}
			}else if(dir == 3) {//좌
				while(--cc >= 0) {
					map[cr][cc] = line;
					count++;
				}
			}else {//우
				while(++cc < N) {
					map[cr][cc] = line;
					count++;
				}
			}
			return count;
		}
		
		public boolean checkLine(int dir) {
			int cr = this.r;
			int cc = this.c;
			if(dir == 1) {//상
				while(--cr >= 0) {
					if(map[cr][cc] != 0) return false;
				}
			}else if(dir == 2) {//하
				while(++cr < N) {
					if(map[cr][cc] != 0) return false;
				}
			}else if(dir == 3) {//좌
				while(--cc >= 0) {
					if(map[cr][cc] != 0) return false;
				}
			}else {//우
				while(++cc < N) {
					if(map[cr][cc] != 0) return false;
				}
			}
			return true;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
	}
	
//	static String src = "1\r\n" + 
//			"5\r\n" + 
//			"1 1 1 1 1\r\n" + 
//			"1 1 0 0 1\r\n" + 
//			"0 0 0 1 1\r\n" + 
//			"0 0 0 1 1\r\n" + 
//			"1 0 1 1 1";
	
}
