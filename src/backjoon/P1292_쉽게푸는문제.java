package backjoon;

import java.util.Scanner;

public class P1292_쉽게푸는문제 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int num1 = scan.nextInt();
		int num2 = scan.nextInt();

		int sum = 0;

		int n = 1;

		int index = 0;

		int[] nums = new int[1000];

		outer: for (int i = 0; i < 1000; i++) {
			// n만큼 반복해서 nums에 n 대입
			for (int j = 0; j < n; j++) {
				nums[index] = n;
				index++;
				if (index == 1000) { //배열 모두 채워지면 break
					break outer;
				}
			}
			n++;

		}

		for (int n1 = num1; n1 <= num2; n1++) {
			sum += nums[n1 - 1];
		}
		System.out.println(sum);

	}

}
