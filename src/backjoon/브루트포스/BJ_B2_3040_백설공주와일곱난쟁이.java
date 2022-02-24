package backjoon.브루트포스;

import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;

public class BJ_B2_3040_백설공주와일곱난쟁이 {
	
	static int[] dwarf;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//scan = new Scanner(new StringReader(src));
		dwarf = new int[9]; //아홉 난쟁이
		
		for (int i = 0; i < 9; i++) {
			dwarf[i] = scan.nextInt();
		}
		
		comb(7, new int[7], 0);
		
	}//main
	
	public static void comb(int toChoose, int[] chosen, int start) {
		
		if(toChoose==0) {
			int sum = 0;
			for (int i : chosen) {
				sum += i;
			}
			if(sum==100) {
				for (int i : chosen) {
					System.out.println(i);
				}
			}
			
			return;
		}
		
		for (int i = start; i < dwarf.length; i++) {
			chosen[chosen.length - toChoose] = dwarf[i];
			comb(toChoose-1, chosen, i+1);
		}
		
	}
	
//	public static String src = "8\r\n" + 
//			"6\r\n" + 
//			"5\r\n" + 
//			"1\r\n" + 
//			"37\r\n" + 
//			"30\r\n" + 
//			"28\r\n" + 
//			"22\r\n" + 
//			"36";
}
