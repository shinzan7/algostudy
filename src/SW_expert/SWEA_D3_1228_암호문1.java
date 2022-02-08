package SW_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_D3_1228_암호문1 {
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	
	private static List<Integer> original = new LinkedList<Integer>();
	private static int numOrigin; //원본 암호문 길이, 암호문
	private static int numOrder; //명령어 길이, 명령어
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//input = new BufferedReader(new StringReader(src));
		
		int T = 10;
		for(int t=0; t<T; t++) {
			numOrigin = Integer.parseInt(input.readLine());
			original.clear();
			
			tokens = new StringTokenizer(input.readLine(), " ");
			for (int i = 0; i < numOrigin; i++) {
				original.add(Integer.parseInt(tokens.nextToken())); 
			}//원본 암호문배열입력
			
			numOrder = Integer.parseInt(input.readLine()); //명령어의 개수 입력
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int i = 0; i<numOrder; i++) {
				tokens.nextToken();
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());
				
				for(int j=0; j<y; j++) { //y개만큼 넣기
					int element = Integer.parseInt(tokens.nextToken());
					original.add(x++, element);
				}
			} //명령어 처리완료
			System.out.print("#"+(t+1)+" ");
			for(int i=0; i<10; i++) {
				System.out.print(original.get(i)+ " ");
			}
			System.out.println();
			
		}// T.C
	}
	

}
