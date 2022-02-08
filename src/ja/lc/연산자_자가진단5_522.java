package ja.lc;

import java.util.Scanner;

public class 연산자_자가진단5_522 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		System.out.println(num1==num2 ? 1 : 0);
		System.out.println(num1!=num2 ? 1 : 0);		
	}
}
