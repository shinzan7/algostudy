package backjoon.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G4_15961_회전초밥 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,d,k,c, dish[], maxCnt, visit[];
	public static void main(String[] args) throws IOException{
//		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //접시 수
		d = Integer.parseInt(st.nextToken()); //초밥 가짓수
		k = Integer.parseInt(st.nextToken()); //연속해서 먹는 수
		c = Integer.parseInt(st.nextToken()); //쿠폰번호
		dish = new int[N];
		visit = new int[d+1];
		for (int i = 0; i < N; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		maxCnt = 0;
		select();
		
		System.out.println(maxCnt);
		
		
	}
	
	private static void select() {
		int cnt = 1; //쿠폰으로 먹으면 하나 빼주기
		for (int i = 0; i < k; i++) {
			if(visit[dish[i]] == 0) {
				cnt++;
				if(dish[i] == c) cnt--; //쿠폰초밥 먹지 않았을때 처음으로 먹으면 -1
			}
			visit[dish[i]]++;
		}
		maxCnt = cnt; //처음 윈도우 상태
		
		for (int i = 0; i < N-1; i++) {
			if(i==N) i = 0; //끝에 도달하면 0으로 초기화
			//먹은거 다시 뱉기
			if(visit[dish[i]] == 1) { //뱃속에 1개만 있었다면
				cnt--;
				if(dish[i] == c) cnt++; //쿠폰초밥 뱉어내면
			}
			visit[dish[i]]--;
			
			int add = (i + k) % N;
			
			if(visit[dish[add]] == 0) { //먹은 적 없으면
				cnt++;
				if(dish[add] == c) cnt--; //쿠폰초밥 먹지 않았을때 처음으로 먹으면 -1
			}
			visit[dish[add]]++;
			
			maxCnt = Math.max(cnt, maxCnt);
		}
		return;
	}
	
//	static String src = "8 50 4 7\r\n" + 
//			"2\r\n" + 
//			"7\r\n" + 
//			"9\r\n" + 
//			"25\r\n" + 
//			"7\r\n" + 
//			"9\r\n" + 
//			"7\r\n" + 
//			"30";
//	
}
