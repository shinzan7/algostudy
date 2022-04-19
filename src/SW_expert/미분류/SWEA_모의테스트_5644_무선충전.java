package SW_expert.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author shinz
 * @since 2022. 2. 16.
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemSubmitHistory.do?contestProbId=AWXRDL1aeugDFAUo&solveclubId=AX5LR3N6iOoDFAX1&problemBoxTitle=2%EC%9B%94+3%EC%A3%BC&problemBoxCnt=3&probBoxId=AX71HJlaULgDFAW0
 * @performance 25,300 kb 133 ms
 * @category 시뮬레이션
 */
public class SWEA_모의테스트_5644_무선충전 {
	static int[][] map;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T; //테스트케이스
	static int M; //총 이동시간
	static int A; //BC의 개수
	static int[] moveA, moveB; //A,B 이동명령
	static int[][] BC; //BC의 좌표x, y, 범위, 출력
	static int result; //A와 B의 충전결과
	static int deltas[][] = {{0,0}, {-1,0}, {0,1}, {1,0}, {0,-1}}; //move 01234
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			moveA = new int[M];
			moveB = new int[M];
			BC = new int[A][4];
			map = new int[10][10];
			result = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {//A이동입력
				moveA[m] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {//B이동입력
				moveB[m] = Integer.parseInt(st.nextToken());
			}
			
			for (int a = 0; a < A; a++) {
				st = new StringTokenizer(br.readLine());
				BC[a][1] = Integer.parseInt(st.nextToken()) - 1;
				BC[a][0] = Integer.parseInt(st.nextToken()) - 1;
				map[BC[a][0]][BC[a][1]] = a; //BC번호 넣기 
				
				BC[a][2] = Integer.parseInt(st.nextToken()); //BC의 범위
				BC[a][3] = Integer.parseInt(st.nextToken()); //BC의 출력
			}
			int Ar = 0;
			int Ac = 0;
			int Br = 9;
			int Bc = 9;

			//충전
			for (int m = 0; m < M; m++) {
				charge(Ar, Ac, Br, Bc);
				
				Ar += deltas[moveA[m]][0];
				Ac += deltas[moveA[m]][1];
				
				Br += deltas[moveB[m]][0];
				Bc += deltas[moveB[m]][1];
				
			}
			charge(Ar, Ac, Br, Bc); //마지막 충전
			
			System.out.println("#"+t+" "+ result);
			
		}//T.C
		
	}//main
	
	static void charge(int Ar, int Ac, int Br, int Bc) {

		PriorityQueue<Integer> queueA = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> queueB = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> queueSame = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < BC.length; i++) {
			
			if((isIn(i, Ar, Ac) && isIn(i, Br, Bc))) {// 둘다 같은곳에 있으면
				queueSame.add(BC[i][3]);
			}else {
				if(isIn(i, Ar, Ac)) { //안에있으면 큐에 넣기
					queueA.add(BC[i][3]);
				}
				if(isIn(i, Br, Bc)) { //안에있으면 큐에 넣기
					queueB.add(BC[i][3]);
				}				
			}
			
		}
		
		if(queueA.size()==0 && queueB.size() == 0 && queueSame.size()>0) { //둘다 겹치는곳에만 있을때
			result += queueSame.poll();
			if(queueSame.size() > 0) result+=queueSame.poll(); //한개 더 있으면
		}
		else if(queueSame.size()==0) { //겹치는 곳이 없을 때
			if(queueA.size() > 0) result += queueA.poll();
			if(queueB.size() > 0) result += queueB.poll();
		}
		else if(queueA.size() > 0 && queueB.size() == 0 && queueSame.size() > 0) { //겹치지만 A는 따로있는곳이 있으면
			int[] arr = new int [3]; //3개 비교 배열
			arr[0] = queueA.poll();
			arr[1] = queueSame.poll();
			if(queueSame.size()>0) arr[2] = queueSame.poll();
			Arrays.sort(arr);
			
			result += arr[2];
			result += arr[1];
		}
		else if(queueA.size() == 0 && queueB.size() > 0 && queueSame.size() > 0) { //겹치지만 B는 따로있는곳이 있으면
			int[] arr = new int [3]; //3개 비교 배열
			arr[0] = queueB.poll();
			arr[1] = queueSame.poll();
			if(queueSame.size()>0) arr[2] = queueSame.poll();
			Arrays.sort(arr);
			
			result += arr[2];
			result += arr[1];
		}
		else if(queueA.size() > 0 && queueB.size() > 0 && queueSame.size() > 0) { //각자 1개이상 있을 때
			int[] arr = new int [4]; //3개 비교 배열
			arr[0] = queueA.poll();
			arr[1] = queueB.poll();
			arr[2] = queueSame.poll();
			if(queueSame.size() > 0) arr[3] = queueSame.poll();
			Arrays.sort(arr);
			
			result += arr[3];
			result += arr[2];
		}
		
		return;
	}
	
	static boolean isIn(int bc, int r, int c) { //BC충전범위 안인지 판단
		int distance = Math.abs(r-BC[bc][0]) + Math.abs(c-BC[bc][1]);
		if(BC[bc][2] >= distance) return true;
		
		return false;
	}

}
