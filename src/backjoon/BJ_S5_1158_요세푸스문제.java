package backjoon;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BJ_S5_1158_요세푸스문제 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int K = scan.nextInt();
		scan.close();
		
		int now = -1; // 갱신할 인덱스
		
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		System.out.print("<");
		while(list.size() > 1) {
			now += K;
			if(now>=N) now = now%N;
			System.out.print(list.get(now)+", ");
			list.remove(now);
			N--;
			now--;
		}
		System.out.print(list.get(0)+">");
		
	}
	
}
