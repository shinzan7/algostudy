package ja.lc;

import java.util.Scanner;

public class 연산자_자가진단7_524 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		boolean a = (num1 != 0);
		boolean b = (num2 != 0);
		
		boolean ans1 = a && b;
		boolean ans2 = a || b;
		
		System.out.println(ans1 + " " + ans2);
	}
}