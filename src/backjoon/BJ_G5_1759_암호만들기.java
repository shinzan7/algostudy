package backjoon;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BJ_G5_1759_암호만들기 {
	
	static int L, C;
	static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
	static char[] alpha;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new StringReader(src));
		
		L = scan.nextInt(); //암호 길이
		C = scan.nextInt(); //알파벳개수
		
		alpha = new char[C];
		
		for (int i = 0; i < C; i++) {
			alpha[i] = scan.next().charAt(0);
		}
		Arrays.sort(alpha);
		
		char[] result = new char[L];
		comb(0, 0, result);
		
	}
	
	public static void comb(int cnt, int start, char[] choosed) {
		
		if(cnt==L) {
			if(check(choosed)) {
				System.out.println(choosed);
			}
			return;
		}
		
		for (int i = start; i < C; i++) {
			choosed[cnt] = alpha[i];
			comb(cnt+1, i+1, choosed);
		}
		
		
	}
	
	public static boolean check(char[] str) {
		int cntV = 0; //모음 카운트
		int cntC = 0; //자음 카운트
		
		out : for (int i = 0; i < L; i++) {
			for (int j = 0; j < vowels.length; j++) {
				if(str[i]==vowels[j]) {
					cntV++;
					continue out;
				}
			}
			cntC++;
		}
		if(cntV >= 1 && cntC >= 2) return true;
		
		return false;
	}
	
	
}
