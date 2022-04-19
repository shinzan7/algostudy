package backjoon.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_6603_로또 {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static int[] nums;
	private static boolean [] isSelected;
	
	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new StringReader(src));
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if(k==0) break;
			nums = new int[k];
			isSelected = new boolean[k];
			
			for (int i = 0; i < k; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			//조합 출력
			combination(6, 0, new int[6]);
			System.out.println();
		}
		
	}
	
	public static void combination(int toChoose, int start, int[] chosed) {
		
		if(toChoose==0) {
			for (int i : chosed) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < nums.length; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				chosed[chosed.length - toChoose] = nums[i];
				combination(toChoose-1, i+1, chosed);
				isSelected[i] = false;
			}
			
		}
		
	}
	
	
//	static String src = "7 1 2 3 4 5 6 7\r\n" + 
//			"8 1 2 3 5 8 13 21 34\r\n" + 
//			"0";
	
}
