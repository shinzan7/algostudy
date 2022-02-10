package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ_S1_1174_줄어드는수 {
	
	private static int N, nums[];
	private static List<Long> allNumbers = new ArrayList<Long>();
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());

		nums = new int[]{9,8,7,6,5,4,3,2,1,0};
		
		comb(0,0);
		Collections.sort(allNumbers);
		
		if(N>allNumbers.size()) System.out.println(-1);
		else System.out.println(allNumbers.get(N-1));
	}
	
	private static void comb(int index, long sum) {
		
		if(!allNumbers.contains(sum)) allNumbers.add(sum);
		
		if(index>=nums.length) return;
		
		comb(index+1, sum*10+nums[index]);
		comb(index+1, sum);
	}

}
