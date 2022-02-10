package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S2_1931_회의실배정 {
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static int[][] times;
	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//input = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(input.readLine());
		times = new int[N][2];
		
		for (int t = 0; t < N; t++) {
			st = new StringTokenizer(input.readLine());
			times[t][0] = Integer.parseInt(st.nextToken());
			times[t][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(times, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
			}
		});
		
		int now = 0;
		int count = 0;
		
		for (int i = 0; i < times.length; i++) {
			if(times[i][0] >= now) {
				now = times[i][1];
				count++;
			}
		}
		System.out.println(count);

	}

}
