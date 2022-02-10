package SW_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA_D4_1233_사칙연산유효성검사 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//br = new BufferedReader(new StringReader(src));
		
		int testCase = 10;
		
		for (int t = 1; t <= testCase; t++) {
			int N = Integer.parseInt(br.readLine());
			int result = 1;
			
			for (int n = 1; n <= N; n++) { //N=171
				st = new StringTokenizer(br.readLine());
				
				if(st.countTokens()>=3) {
					//int index = Integer.parseInt(st.nextToken());
					st.nextToken();
					String operator = st.nextToken();
					if(!(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/"))) { // 사칙연산이 아닐때
						for (int i = n; i < N; i++) {
							br.readLine();
						}
						result = 0;
						break;
					}
					while(st.hasMoreTokens()) {
						st.nextToken();
					}
				}
				else {
					st.nextToken();
					String isInt = st.nextToken();
					if((isInt.equals("+") || isInt.equals("-") || isInt.equals("*") || isInt.equals("/"))) {
						for (int i = n; i < N; i++) {
							br.readLine();
						}
						result = 0;
						break;
					}
				}
			}
			System.out.println("#"+t+" "+result);
			
		}//T.C
		
	}//main
	
}
