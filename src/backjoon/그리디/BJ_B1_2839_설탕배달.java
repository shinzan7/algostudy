package backjoon.그리디;

import java.util.Scanner;

public class BJ_B1_2839_설탕배달 {

	static Scanner scan = new Scanner(System.in);
	static int N, count;

	public static void main(String[] args) {

		N = scan.nextInt();
		scan.close();
		count = 0;
		
		while(N > 0) {
			if(N%5 == 0) {
				count += N/5;
				break;
			}else if(N >= 3) {
				N -= 3;
				count++;
			}else if(N < 3){
				count = -1;
				break;
			}
		}
		
		System.out.println(count);
		
	}

}
