package backjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S3_3273_두수의합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new StringReader(src));
//		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		int x = Integer.parseInt(br.readLine());

		br.close();
		
		Collections.sort(list);
		
		int result = 0;
		
		int start = 0;
		int end = list.size() - 1;
		int sum = 0;
		
		while(start < end) {
			sum = list.get(start) + list.get(end);
			if(sum == x) {
				result++;
			}
			
			if(sum <= x) {
				start++;
			}else {
				end--;
			}
		}
		
		System.out.println(result);

	}
	
	
	
//	static String src = "9\r\n" + 
//			"5 12 7 10 9 1 2 3 11\r\n" + 
//			"13";
	
}
