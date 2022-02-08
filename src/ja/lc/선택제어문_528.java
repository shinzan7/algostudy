package ja.lc;

import java.util.Scanner;

public class 선택제어문_528 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		
		System.out.println(num1);
		if(num1 < 0) {
			System.out.println("minus");
		}
	}
}