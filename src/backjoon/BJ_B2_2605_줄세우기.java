package backjoon;

import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BJ_B2_2605_줄세우기 {
	
	static Scanner scan = new Scanner(System.in);
	static int N;
	static List<Integer> list = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		
		N = scan.nextInt();
		
		for (int i = 1; i <= N; i++) {
			int ticket = scan.nextInt();
			list.add(list.size() - ticket, i);
		}
		
		for (Integer n : list) {
			System.out.print(n + " ");
		}
		
	}

}
