package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S5_1475_방번호 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new StringReader(src));
//		st = new StringTokenizer(br.readLine());
		
		// 한 세트 0~9
		// 숫자 카운트해서 가장 많이 나오는 수
		// 6,9는 같이 카운트 6개, 3개 -> 5세트
		
		int arr[] = new int[10];
		
		String str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			int n = str.charAt(i) - '0';
			arr[n]++;
		}
		
		int sum = arr[6] + arr[9];
		if(sum%2==0) {
			sum /= 2;
		}else {
			sum = sum/2 + 1;
		}
		arr[6] = sum;
		arr[9] = sum;
		
		int max = 0;
		for (int i = 0; i < 10; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		System.out.println(max);

		br.close();
		

	}
	
	
	
//	static String src = "888888";
	
}
