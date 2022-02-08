package backjoon;

import java.util.Scanner;

public class P5086_배수와약수 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int num1 = scan.nextInt();
		int num2 = scan.nextInt();

		boolean factor = false;
		boolean multiple = false;
		
		while (num1 != 0 && num2 != 0) { //둘다 0인지 검사
			factor = false;
			multiple = false;
			
			if (num2 % num1 == 0) {
				factor = true;
			}
			if (num1 % num2 == 0) {
				multiple = true;
			}

			if (factor) {
				System.out.println("factor");
			} else if (multiple) {
				System.out.println("multiple");
			} else {
				System.out.println("neither");
			}
			num1 = scan.nextInt();
			num2 = scan.nextInt();
		}
	}
}
