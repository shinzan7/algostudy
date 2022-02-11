package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_B2_2309_일곱난쟁이 {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static int[] arr = new int[9];
	private static int[] real = new int[7];
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		combination(7, new int[7], 0);
		Arrays.sort(real);
		for (Integer r : real) {
			System.out.println(r);
		}
	}
	
	private static void combination(int toChoose, int[] chosed, int start) {
		
		if(toChoose==0) {
			int sum = 0;
			for (int i : chosed) {
				sum += i;
			}
			if(sum == 100) real = chosed.clone();
			
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
				chosed[chosed.length - toChoose] = arr[i];
				combination(toChoose-1, chosed, i+1);
		}
		
	}
	
}
