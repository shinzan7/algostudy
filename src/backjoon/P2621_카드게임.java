package backjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P2621_카드게임 {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);

		String[] colors = new String[5];
		int[] nums = new int[5];
		
		for(int i=0; i<5; i++) {
			colors[i] = scan.next();
			nums[i] = scan.nextInt();
		}

		
//		String[] colors = {"R", "Y", "Y", "G", "B"};
//		int[] nums = {5,5,4,9,4};
		
		//입력 완료

		ArrayList<String> cArray = new ArrayList<>(Arrays.asList(colors));
		
		int cntR = Collections.frequency(cArray, "R");
		int cntB = Collections.frequency(cArray, "B");
		int cntY = Collections.frequency(cArray, "Y");
		int cntG = Collections.frequency(cArray, "G");
		
		Arrays.sort(nums); //nums 정렬
		int cntSequential = 1; //연속되는 수
		
		for(int i=0; i<5; i++) {
			int temp = 1;
			for(int j=i; j<4; j++) {
				if(nums[j+1]-nums[j] == 1) {
					temp++;
				}
				if(cntSequential < temp) {
					cntSequential = temp;
				}
			}
		}
		
		int[] cntN = new int[10]; //nums 숫자 카운팅
		
		for(int num : nums) {
			cntN[num]++;
		}
		
		int[] cntNCopy = cntN.clone();
		
		Arrays.sort(cntNCopy);
		int cntNMax = cntNCopy[9]; //같은 숫자 최대값
		
		int sameNum1 = 0;
		int sameNum2 = 0;
		
		if(cntNMax >= 2) {
			for(int i =0; i<10; i++) {
				if(cntN[i] == cntNMax) {
					sameNum1 = i;
				}
				
				if(cntNMax == 3 && cntN[i] == 2) {
					sameNum2 = i;
				}else if(sameNum1 != 0 && cntNMax == 2 && cntN[i] == 2&& sameNum2 == 0) {
					sameNum2 = sameNum1;
					sameNum1 = i;
				}
			}
		}
		
		int result = 0;
		int tempR = 0;
		
		//1. 5장 색 같음, 연속숫자
		if((cntR==5 || cntB==5 || cntY==5 || cntG==5) && cntSequential ==5 ) {
			tempR = 900 + nums[4];
			
			if(tempR > result) { // 최대값 갱신
				result = tempR;
			}
		}
		
		//2. 4장 숫자 같음
		if(cntNMax == 4) {
			tempR = 800 + sameNum1;
			
			if(tempR > result) { // 최대값 갱신
				result = tempR;
			}
		}
		
		//3. 3장/2장 숫자 같음
		if(cntNMax == 3 && cntNCopy[8] == 2) {
			tempR = 10 * sameNum1 + sameNum2 + 700;
			
			if(tempR > result) { // 최대값 갱신
				result = tempR;
			}
		}
		
		//4. 5장 색 같음
		if(cntR==5 || cntB==5 || cntY==5 || cntG==5) {
			tempR = 600 + nums[4];
			
			if(tempR > result) { // 최대값 갱신
				result = tempR;
			}
		}
		
		//5. 5장 숫자가 연속
		if(cntSequential == 5) {
			tempR =  500 + nums[4];
			
			if(tempR > result) { // 최대값 갱신
				result = tempR;
			}
		}
		
		//6. 3장 숫자 같음
		if(cntNMax == 3) {
			tempR =  400 + sameNum1;
			
			if(tempR > result) { // 최대값 갱신
				result = tempR;
			}
		}
		
		//7. 2장/2장 숫자 같음
		if(cntNMax == 2 && cntNCopy[8] == 2) {
			tempR =  10 * sameNum1 + sameNum2 + 300;
			
			if(tempR > result) { // 최대값 갱신
				result = tempR;
			}
		}
		
		//8. 2장 숫자 같음
		if(cntNMax == 2) {
			tempR =  200 + sameNum1;
			
			if(tempR > result) { // 최대값 갱신
				result = tempR;
			}
		}
		
		//9. else
		tempR = 100 + nums[4];
		if(tempR > result) { // 최대값 갱신
			result = tempR;
		}
		
		System.out.println(result);

	}

}
