package backjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S1_17615_볼모으기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	
	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		br.close();
		char[] balls = str.toCharArray();
		
		int leftB = moveLeft(balls, 'B');
		int leftR = moveLeft(balls, 'R');
		int rightB = moveRight(balls, 'B');
		int rightR = moveRight(balls, 'R');
		int result = Math.min(Math.min(leftB, leftR), Math.min(rightR, rightB));
		
		System.out.println(result);
		
	}
	
	static int moveLeft(char[] balls, char color) {
		int cnt = 0;
		int firstIdx = 0;
		
		for (int i = 0; i < N; i++) {
			if(balls[i] != color) { //첫번째로 다른색깔 나오는 인덱스 i
				firstIdx = i;
				break;
			}
		}
		
		for (int i = firstIdx; i < N; i++) {
			if(balls[i] == color) cnt++; //옮길 색 나올때마다 cnt증가
		}
		
		return cnt;
	}
	
	static int moveRight(char[] balls, char color) {
		int cnt = 0;
		int firstIdx = 0;
		
		for (int i = N-1; i >= 0; i--) {
			if(balls[i] != color) { //첫번째로 다른색깔 나오는 인덱스 i
				firstIdx = i;
				break;
			}
		}
		
		for (int i = firstIdx; i >= 0; i--) {
			if(balls[i] == color) cnt++; //옮길 색 나올때마다 cnt증가
		}
		
		return cnt;
	}

}
