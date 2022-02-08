package ja.lc;

import java.util.Scanner;

public class 연산자_자가진단2_519 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		scanner = new Scanner(src);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		int num3 = scanner.nextInt();
		
		int sum = num1 + num2 + num3;
		
		int avg = sum / 3;
		
		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);
	}
	
//	private static String src = "10 25 33";

}
