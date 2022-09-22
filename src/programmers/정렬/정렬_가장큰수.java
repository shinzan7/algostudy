package programmers.정렬;

import java.util.ArrayList;
import java.util.Collections;

public class 정렬_가장큰수 {
	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};
		String a = solution(numbers);
		System.out.println(a);
	}
	
	
	static String solution(int[] numbers) {
		String answer = "";
		
		ArrayList<String> nums = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			nums.add(""+ numbers[i]);
		}
		Collections.sort(nums, (a,b) -> (b+a).compareTo(a+b));
		if(nums.get(0).charAt(0) == '0') return "0"; //원소가 전부 0일 경우
		for (int i = 0; i < nums.size(); i++) {
			answer += nums.get(i);
		}
		
		return answer;
	}
}
