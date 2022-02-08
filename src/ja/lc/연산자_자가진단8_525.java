package ja.lc;

import java.util.Scanner;

public class 연산자_자가진단8_525 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		boolean ans1 = (num1 > num2) && (num1 > num3);
		boolean ans2 = (num1 == num2) && (num1 == num3);		
		
		System.out.println(ans1 + " " + ans2);
	}
}