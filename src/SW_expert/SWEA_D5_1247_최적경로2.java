package SW_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D5_1247_최적경로2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, min;
	static location company, home, clients[];
	
	public static class location{
		int x;
		int y;
		public location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		br = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			min = Integer.MAX_VALUE;
			
			company = new location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			clients = new location[N];
			for (int i = 0; i < N; i++) {
				clients[i] = new location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			backtrack(0, 0, 0, 0);
			sb.append("#").append(t).append(" ");
			sb.append(min).append("\n");
			
		}// T.C
		
		System.out.println(sb);
		
	}// main
	
	public static void backtrack(int cnt, int flag, int ans, int before) {
		//가지치기
		if(ans > min) return;
		
		if(cnt == N) {
			ans += getDistance(clients[before], home);
			if(ans < min) min = ans;
			
			return;
		}
		
		//시도
		for (int i = 0; i < N; i++) {
			if((flag & 1<<i) != 0) continue;
			
			if(cnt == 0) {//처음인 경우
				backtrack(cnt+1, flag | 1<<i, ans + getDistance(company, clients[i]), i);
			}else {
				backtrack(cnt+1, flag | 1<<i, ans + getDistance(clients[before], clients[i]), i);
			}
		}
		
	}
	
	public static int getDistance(location a, location b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}

	private static String src = "10\r\n" + 
			"5\r\n" + 
			"0 0 100 100 70 40 30 10 10 5 90 70 50 20\r\n" + 
			"6\r\n" + 
			"88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14\r\n" + 
			"7\r\n" + 
			"22 47 72 42 61 93 8 31 72 54 0 64 26 71 93 87 84 83\r\n" + 
			"8\r\n" + 
			"30 20 43 14 58 5 91 51 55 87 40 91 14 55 28 80 75 24 74 63\r\n" + 
			"9\r\n" + 
			"3 9 100 100 16 52 18 19 35 67 42 29 47 68 59 38 68 81 80 37 94 92\r\n" + 
			"10\r\n" + 
			"39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36\r\n" + 
			"10\r\n" + 
			"26 100 72 2 71 100 29 48 74 51 27 0 58 0 35 2 43 47 50 49 44 100 66 96\r\n" + 
			"10\r\n" + 
			"46 25 16 6 48 82 80 21 49 34 60 25 93 90 26 96 12 100 44 69 28 15 57 63\r\n" + 
			"10\r\n" + 
			"94 83 72 42 43 36 59 44 52 57 34 49 65 79 14 20 41 9 0 39 100 94 53 3\r\n" + 
			"10\r\n" + 
			"32 79 0 0 69 58 100 31 67 67 58 66 83 22 44 24 68 3 76 85 63 87 7 86\r\n" + 
			"";
	
}
