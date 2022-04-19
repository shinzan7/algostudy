package SW_expert.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA_D4_1861_정사각형방 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int N;
	static int startNum; //시작하는 방 번호
	static int maxMove; //최대 이동거리, 
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}}; //상하좌우
	
	public static void main(String[] args) throws IOException {
		//br = new BufferedReader(new StringReader(src));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			maxMove = 1;
			startNum = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			//입력완료
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					findRoute(r, c, 1, map[r][c]);
				}
			}
			System.out.println("#"+t+" "+startNum+" "+maxMove);
			
		}//T.C
		
	}//main
	
	private static void findRoute(int r, int c, int count, int start) {

		for (int i = 0; i < 4; i++) { // 상하좌우
			int sr = r + deltas[i][0];
			int sc = c + deltas[i][1];
			
			if((sr >= 0 && sr < N) && (sc >= 0 && sc < N)) { //이동 가능하면
				if(map[sr][sc]-map[r][c] == 1) { //이동하려는 곳이 1 크다면
					findRoute(sr, sc, ++count, start);
				}
			}
		} // 움직일 곳이 없으면 종료
		
		if(maxMove < count) { // 최대이동거리 갱신
			maxMove = count;
			startNum = start;
		}else if(maxMove == count) { //같다면 적은번호로
			startNum = (startNum < start)? startNum : start;
		}
		
	}
	
}
