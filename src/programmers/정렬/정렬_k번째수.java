package programmers.정렬;

import java.util.Arrays;

public class 정렬_k번째수 {
	public static void main(String[] args) {
		
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		System.out.println(Arrays.toString(solution(array, commands)));
		
	}
	
	
	static int[] solution(int[] array, int[][] commands) {
		int[] result = new int[commands.length];
		
		for (int idx = 0; idx < commands.length; idx++) {
			int i = commands[idx][0];
			int j = commands[idx][1];
			int k = commands[idx][2];
			
			int[] cut = new int[j-i+1];
			for (int l = 0; l < cut.length; l++) {
				cut[l] = array[i-1+l];
			}
			Arrays.sort(cut);
			result[idx] = cut[k-1];
		}
		
		return result;
	}
}
