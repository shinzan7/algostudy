package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S5_2635_수_이어가기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static List<Integer> nums = new LinkedList<Integer>();
	static List<Integer> result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		int count = 2;
		
		for (int i = 1; i <= N; i++) {
			nums.add(N);
			nums.add(i);
			int diff = N - i;
			while(diff >= 0) {
				nums.add(diff);
				diff = nums.get(nums.size()-2) - nums.get(nums.size()-1);
			}
			if(nums.size()>count) {
				count = nums.size();
				result = new ArrayList<Integer>(nums);
			}
			
			nums.clear();
		}
		sb.append(result.size()).append("\n");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i)).append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

	
}
