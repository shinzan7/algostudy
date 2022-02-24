package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S4_2477_참외밭 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int K, nums[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//br = new BufferedReader(new StringReader(src));
		K = Integer.parseInt(br.readLine());
		nums = new int[6][2];
		int[] cntDir = new int[5];
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			nums[i][0] = dir;
			nums[i][1] = Integer.parseInt(st.nextToken());
			cntDir[dir]++;
		}
		int big[] = new int[2]; //큰 변 2개
		for (int i = 1, b = 0; i <= 4; i++) {
			if(cntDir[i] == 1) {
				big[b++] = i;
			}
		}
		int ans = 0;
		for (int i = 0; i < 6; i++) {
			if(nums[i][0] == big[0] || nums[i][0] == big[1]) {
				if(i==0 && nums[1][0] == big[0] || nums[1][0] == big[1]) {
					//앞2개에 큰 변
					ans = nums[i][1] * nums[i+1][1];
					ans -= nums[i+3][1] * nums[i+4][1];
				}else if(i==0) {
					//양쪽으로 갈라진 큰 변
					ans = nums[i][1] * nums[5][1];
					ans -= nums[i+2][1] * nums[i+3][1];
				}
				else if(i==1) {
					ans = nums[i][1] * nums[i+1][1];
					ans -= nums[i+3][1] * nums[i+4][1];
				}else if(i==2) {
					//가운데의 큰 변
					ans = nums[i][1] * nums[i+1][1];
					ans -= nums[0][1] * nums[5][1];
				}else {
					//끝에있는 큰 변
					ans = nums[i][1] * nums[i+1][1];
					ans -= nums[i-2][1] * nums[i-3][1];
				}
				break;
			}
		}
		System.out.println(ans * K);
	}
	
	
//	static String src = "7\r\n" + 
//			"4 50\r\n" + 
//			"2 160\r\n" + 
//			"3 30\r\n" + 
//			"1 60\r\n" + 
//			"3 20\r\n" + 
//			"1 100";
	
}
