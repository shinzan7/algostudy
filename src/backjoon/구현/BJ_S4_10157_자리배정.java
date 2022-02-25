package backjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S4_10157_자리배정 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R,C,K, map[][];
	static int count = 1;
	
	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		br.close();
		map = new int[R][C];
		
		if(R*C >= K) {
			//찾으려는 번호가 있으면
			map[R-1][0] = 1;
			fill(R-1, 0);
			
			out: for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(map[r][c] == K) {
						int x = c+1;
						int y = R-r;
						System.out.print(x + " " + y);
						break out;
					}
				}
			}			
		}
		else {
			//찾으려는 번호 없으면 0 출력
			System.out.print(0);
		}
		

	}
	
	static void fill(int r, int c) {
		if(count == R*C) return;
		
		//위로 갈수있을때까지 채우기
		while(r-1>=0 && map[r-1][c] == 0) { 
			r--;
			map[r][c] = ++count;
		}

		//오른쪽으로 갈수있을때까지 채우기
		while(c+1<C && map[r][c+1] == 0) {
			c++;
			map[r][c] = ++count; 
		}
		//아래로 갈수있을때까지 채우기
		while(r+1<R && map[r+1][c] == 0) { 
			r++;
			map[r][c] = ++count;
		}
		//왼쪽으로 갈수있을때까지 채우기
		while(c-1>=0 && map[r][c-1] == 0) {
			c--;
			map[r][c] = ++count; 
		}
		fill(r, c);
	}
	
//	static String src = "100 100\r\n" + 
//			"3000";
	
}
