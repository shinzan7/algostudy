package SW_expert.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_D3_prof_조합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int MOD = 1234567891;
	static int n, r;
	public static void main(String[] args) throws IOException{
//		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			long fac[] = new long[n+1];
			fac[0] = 1;
			for (int i = 1; i <= n; i++) {
				fac[i] = (fac[i-1] * i) % MOD;
			}
			long down = (fac[r] * fac[n-r]) % MOD;
			long down2 = ferma(down, MOD - 2);
			
			long result = (fac[n] * down2) % MOD;
			sb.append("#").append(t).append(" ");
			sb.append(result).append("\n");
		}//tc
		System.out.println(sb);
	}
	
	private static long ferma(long n, int x) {
		if(x==0) return 1;
		long temp = ferma(n, x/2);
		long ans = (temp * temp) % MOD;
		if(x%2 == 0) {
			return ans;
		}else {
			return (ans * n) % MOD;
		}
		
	}
	
	static String src = "1\r\n" + 
			"10 2";
	
}
