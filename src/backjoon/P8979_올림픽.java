package backjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class P8979_올림픽 {
	
	static int [][] gsb;
	static int N, K;
	static int cnt = 0;

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(System.in);
//		Scanner scan = new Scanner(new FileInputStream("input.txt"));
		
		
		N = scan.nextInt();
		K = scan.nextInt();
		
		gsb = new int [N][5];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<4; j++) {
				gsb[i][j] = scan.nextInt();
			}
		} // 입력완료

		int[][] temp = new int[N][5];
		
		outer : while(true) { //더이상 변경없을때까지 순위계산
			
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
//					System.out.println(i+" "+j);
					if(compare(i, j) == 1) {
						temp[i] = gsb[i].clone();
						gsb[i] = gsb[j].clone();
						gsb[j] = temp[i].clone();
						continue outer; //순위변경이 있으면 처음부터
					}else if(compare(i, j) == 2) { //비겼으면 5번째 배열에 비긴 나라숫자 추가
						gsb[i][4] = gsb[i][0];
						gsb[j][4] = gsb[i][0];
					}
				}
			}
			break outer; //순위변경이 없으면 break
		}
		
//		for(int[] g : gsb) {
//			System.out.println(Arrays.toString(g));
//		}
		
		
		
		out : for(int i=0; i<N; i++) {
			if(gsb[i][0] == K && gsb[i][4] == 0) {
				System.out.println(i);
			}else if(gsb[i][0] == K && gsb[i][4] != 0) {
				for(int j=0; j<N ;j++) {
					if(gsb[j][4] == gsb[i][4]) { //비긴 숫자 같을때 순위찾기
						System.out.println(j+1);
						break out;
					}
				}
			}
		}
		
	} // main
	
	//순위 비교
	public static int compare(int a, int b) { // a승:0 , b승:1, 비김:2
		if(gsb[a][1] < gsb[b][1]) { // 금메달비교
			return 1;
		}else if(gsb[a][1] == gsb[b][1]) { // 은메달 비교
			if(gsb[a][2] < gsb[b][2]) {
				return 1;
			}else if(gsb[a][2] == gsb[b][2]) { // 동메달 비교
				if(gsb[a][3] < gsb[b][3]) {
					return 1;
				}else if(gsb[a][3] == gsb[b][3]) { //비김
					return 2;
				}
			}
		}
		
		return 0;
	}

	
}
