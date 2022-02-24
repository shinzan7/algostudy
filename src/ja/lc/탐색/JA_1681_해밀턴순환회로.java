package ja.lc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JA_1681_해밀턴순환회로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, minD ,map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		minD = Integer.MAX_VALUE;
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		dfs(0, 1, 0);
		System.out.println(minD);
	}
	
	static void dfs(int now, int flag, int sum) {
		//최솟값 초과하면 가지치기
		if(sum >= minD) return;
		
		//모두 방문했으면 리턴
		if(flag == (1<<N) - 1) {
			if(map[now][0] == 0) { //회사로 가는길 없을 때
				return;
			}
			else {	
				sum += map[now][0];
				minD = Math.min(sum, minD);
				return;
			}			
		}
		
		//갈수있으면 더하기
		for (int i = 0; i < N; i++) {
			if((flag & 1<<i) != 0) continue;
			
			if(map[now][i] != 0) {
				dfs(i, flag | 1<<i, sum + map[now][i]);
			}
		}
	}
	
	
//	static String src = "6\r\n" + 
//			"0 93 23 32 39 46 \r\n" + 
//			"0 0 7 58 59 13 \r\n" + 
//			"40 98 0 14 33 98 \r\n" + 
//			"3 39 0 0 13 16 \r\n" + 
//			"51 25 19 88 0 47 \r\n" + 
//			"65 81 63 0 6 0 \r\n" + 
//			"";
	
}
