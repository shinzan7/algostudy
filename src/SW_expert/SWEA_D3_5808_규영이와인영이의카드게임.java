package SW_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_D3_5808_규영이와인영이의카드게임 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int T, countW, countL;
	static int[] cards; //9개 숫자
	static int[] leftCards; //나머지 9개 숫자
	static List<Integer> eightteen;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		br = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			countW = 0;
			countL = 0;
			eightteen = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18));
			st = new StringTokenizer(br.readLine());
			cards = new int [9];
			leftCards = new int [9];
			
			for (int i = 0; i < 9; i++) {
				cards[i] = Integer.parseInt(st.nextToken());
				eightteen.remove(Integer.valueOf(cards[i]));
			}
			
			for (int i = 0; i < 9; i++) {
				leftCards[i] = eightteen.get(i);
			}
			
			permutationCard(9, new int[9], new boolean[9]);
			System.out.println("#"+t+" "+countW+" "+countL);
			
		}//T.C
		
	}//main
	
	private static void permutationCard(int toChoose, int[] choosed, boolean[] isChoosed) {
		
		if(toChoose == 0) {
			int sum = 0; //규영이의 총점 - 인영이의 총점
			
			for (int i = 0; i < cards.length; i++) {
				if(cards[i] > choosed[i]) { //규영 숫자가 높을 때
					sum += (cards[i] + choosed[i]);
				}else if(cards[i] < choosed[i]) {//인영 숫자가 높을 때
					sum -= (cards[i] + choosed[i]);
				}
			}
			
			if(sum > 0) {
				countW++;
			}
			else if(sum < 0) {
				countL++;
			}
			
			return;
		}
		
		for (int i = 0; i < leftCards.length; i++) {
			if(!isChoosed[i]) {
				isChoosed[i] = true;
				choosed[choosed.length - toChoose] = leftCards[i];
				permutationCard(toChoose-1, choosed, isChoosed);
				isChoosed[i] = false;
			}
		}

	}
	
//	private static String src = "4\r\n" + 
//			"1 3 5 7 9 11 13 15 17\r\n" + 
//			"18 16 14 12 10 8 6 4 2\r\n" + 
//			"13 17 9 5 18 7 11 1 15\r\n" + 
//			"1 6 7 9 12 13 15 17 18";
}
