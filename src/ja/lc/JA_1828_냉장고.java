package ja.lc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JA_1828_냉장고 {
	
	static class temperature implements Comparable<temperature>{
		
		int minT;
		int maxT;
		
		public temperature(int minT, int maxT) {
			super();
			this.minT = minT;
			this.maxT = maxT;
		}

		@Override
		public int compareTo(temperature o) {
			return this.maxT != o.maxT? this.maxT - o.maxT : this.minT - o.minT;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//br = new BufferedReader(new StringReader(src));
		
		int T = Integer.parseInt(br.readLine());
		temperature[] temps = new temperature[T];
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			temps[t] = new temperature(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		br.close();
		
		Arrays.sort(temps);
		
		int count = 1;
		int start = temps[0].minT;
		int end = temps[0].maxT;
		
		for (int i = 1; i < temps.length; i++) {
			if(end < temps[i].minT) { // 온도 떨어져있으면 냉장고 하나 추가하고 범위 다음샘플으로
				count++;
				start = temps[i].minT;
				end = temps[i].maxT;
			}else { //범위 좁히기
				start = start > temps[i].minT? start : temps[i].minT;
				end = end < temps[i].maxT? end : temps[i].maxT;
			}
		}
		
		System.out.println(count);
		
	}//main
	
	
//	static String src = "4\r\n" + 
//			"-15 5\r\n" + 
//			"-10 36\r\n" + 
//			"10 73\r\n" + 
//			"27 44";
}
