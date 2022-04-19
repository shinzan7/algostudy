package SW_expert.미분류;

import java.util.Scanner;

public class SWEA_D3_1289_원재의메모리복구하기 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for(int t=0; t<T; t++) {
			char[] memory = scan.next().toCharArray();
			int count = 0;
			char temp = '0';
			
			for(int i=0; i<memory.length; i++) {
				if(memory[i] != temp) {
					temp = memory[i];
					count++;
				}
			}
			System.out.printf("#%d %d\n", t+1, count);
			
		}
		
	}
}
