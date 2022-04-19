package backjoon.미분류;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_S5_5568_카드놓기 {
	
	static int N, K;
	static String[] cards, numbers;
	static boolean[] isSelected;
	static List<Integer> intNums = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		K = scan.nextInt();
		cards = new String[N];
		numbers = new String[K];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			cards[i] = scan.next();
		}
		scan.close();
		
		makeNum(0);
		System.out.println(intNums.size());
		
	}
	
	public static void makeNum(int cnt) {
		
		if(cnt==K) {
			String allNum = "";
			for (String string : numbers) {
				allNum += string;
			}
			if(!intNums.contains(Integer.parseInt(allNum))) {
				intNums.add(Integer.parseInt(allNum));
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			
			numbers[cnt] = cards[i];
			isSelected[i] = true;
			
			makeNum(cnt+1);
			isSelected[i] = false;
		}
		
	}
}
