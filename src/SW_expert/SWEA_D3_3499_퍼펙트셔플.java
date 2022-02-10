package SW_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_D3_3499_퍼펙트셔플 {
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static int T,N;
	private static String[] cards;
	private static List<String> result;
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(input.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(input.readLine());
			cards = new String[N];
			result = new ArrayList<String>();
			
			st = new StringTokenizer(input.readLine());
			
			for (int n = 0; n < N; n++) {
				cards[n] = st.nextToken();
			}
			//입력완료
			
			if(N%2==1) {
				String[] c1 = new String[(N/2) + 1];
				String[] c2 = new String[(N/2)];
				
				for(int i=0; i<=N/2; i++) {
					c1[i] = cards[i];
				}
				for(int j=(N/2)+1; j<N; j++) {
					c2[j-(N/2)-1] = cards[j];
				}
				
				for(int k=0; k<N/2; k++) {
					result.add(c1[k]);
					result.add(c2[k]);
				}
				result.add(c1[N/2]);
				
				System.out.print("#"+(t+1));
				for (int i = 0; i < result.size(); i++) {
					System.out.print(" "+result.get(i));
				}
				System.out.println();
			}
			else {
				String[] c1 = new String[(N/2)];
				String[] c2 = new String[(N/2)];
				
				for(int i=0; i<N/2; i++) {
					c1[i] = cards[i];
				}
				for(int j=(N/2); j<N; j++) {
					c2[j-(N/2)] = cards[j];
				}
				for(int k=0; k<N/2; k++) {
					result.add(c1[k]);
					result.add(c2[k]);
				}
				System.out.print("#"+(t+1));
				for (int i = 0; i < result.size(); i++) {
					System.out.print(" "+result.get(i));
				}
				System.out.println();
			}
			
		}//T.C
		
	}//main
	
//	private static String src = "3\r\n" + 
//			"6\r\n" + 
//			"A B C D E F\r\n" + 
//			"4\r\n" + 
//			"JACK QUEEN KING ACE\r\n" + 
//			"5\r\n" + 
//			"ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA";
}
