package ja.lc;

import java.util.Scanner;

public class 연산자_자가진단4_521 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int mlt = num1++ * --num2;
		
		System.out.printf("%d %d %d", num1, num2, mlt);
		
	}

}
