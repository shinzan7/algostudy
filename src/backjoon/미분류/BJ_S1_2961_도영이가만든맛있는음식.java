package backjoon.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S1_2961_도영이가만든맛있는음식 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static int[][] flavor; //신맛 쓴맛 배열
	private static int min = Integer.MAX_VALUE; //차이 최솟값
	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		flavor = new int[N][2];
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			flavor[n][0] = Integer.parseInt(st.nextToken());
			flavor[n][1] = Integer.parseInt(st.nextToken());
		}
		br.close(); // 입력완료
		
		powerDup(N, new boolean[N]);
		System.out.println(min);
		
	}
	
	private static void powerDup(int toCheck, boolean[] checked) {
		// base part
		if (toCheck == 0) {
			int tempDiff = calcul(checked); //신맛,쓴맛 차이 구하기
			if(min > tempDiff) min = tempDiff; //최솟값 갱신
			
			return;
		}

		// inductive part
		checked[checked.length - toCheck] = true;
		powerDup(toCheck - 1, checked);
		checked[checked.length - toCheck] = false;
		powerDup(toCheck - 1, checked);
	}
	
	private static int calcul(boolean[] checked) {
		List<int []> choosed = new LinkedList<int []>();
		for (int i = 0; i < checked.length; i++) {
			if(checked[i]) choosed.add(flavor[i]);
		}
		if(choosed.size()==0) return Integer.MAX_VALUE;
		
		int sour = 1; //신맛들의 곱
		int bit = 0; //쓴맛들의 합
		
		for (int i = 0; i < choosed.size(); i++) {
			sour *= choosed.get(i)[0];
			bit += choosed.get(i)[1];
		}
		
		return Math.abs(sour - bit);
	}
	
//	private static String src = "4\r\n" + 
//			"1 7\r\n" + 
//			"2 6\r\n" + 
//			"3 8\r\n" + 
//			"4 9";
	
}
