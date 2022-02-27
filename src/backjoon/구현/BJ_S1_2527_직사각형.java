package backjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_2527_직사각형 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Square[] sqrs;
	static Square sq1, sq2;
	
	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new StringReader(src));

		for (int t = 1; t <= 4; t++) {
			sqrs = new Square[2];
			st = new StringTokenizer(br.readLine());
			
			int ldx = Integer.parseInt(st.nextToken());
			int ldy = Integer.parseInt(st.nextToken());
			int rux = Integer.parseInt(st.nextToken());
			int ruy = Integer.parseInt(st.nextToken());
			sq1 = new Square(ldx, ldy, rux, ruy);
			
			ldx = Integer.parseInt(st.nextToken());
			ldy = Integer.parseInt(st.nextToken());
			rux = Integer.parseInt(st.nextToken());
			ruy = Integer.parseInt(st.nextToken());
			sq2 = new Square(ldx, ldy, rux, ruy);
			//입력완료
			
			// c 점
			if(sq1.ldx == sq2.rux && sq1.ldy == sq2.ruy ||
			   sq1.ldx == sq2.rux && sq1.ruy == sq2.ldy ||
			   sq1.rux == sq2.ldx && sq1.ruy == sq2.ldy ||
			   sq1.rux == sq2.ldx && sq1.ldy == sq2.ruy) {
				sb.append("c").append("\n");
			}
			
			// b 선분
			else if((sq2.ldy == sq1.ruy || sq2.ruy == sq1.ldy) && !(sq1.ldx > sq2.rux || sq1.rux < sq2.ldx)) {
				sb.append("b").append("\n"); //위아래 선분
			}
			else if((sq2.ldx == sq1.rux || sq2.rux == sq1.ldx) && !(sq1.ldy > sq2.ruy || sq1.ruy < sq2.ldy)) {
				sb.append("b").append("\n"); //좌우 선분
			}
			
			// d 분리
			else if(sq1.rux < sq2.ldx || sq1.ruy < sq2.ldy || sq1.ldy > sq2.ruy || sq1.ldx > sq2.rux) {
				sb.append("d").append("\n");
			}
			
			// a 겹치는경우
			else {
				sb.append("a").append("\n");
			}
			
		}//T.C
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
		
	}//main
	
	static class Square{
		int ldx, ldy; //왼쪽아래 좌표
		int rux, ruy; //오른쪽위 좌표
		public Square(int ldx, int ldy, int rux, int ruy) {
			super();
			this.ldx = ldx;
			this.ldy = ldy;
			this.rux = rux;
			this.ruy = ruy;
		}
		@Override
		public String toString() {
			return "[" + ldx + ", " + ldy + "], [" + rux + ", " + ruy + "]";
		}
		
	}
	
	
//	static String src = "3 10 50 60 100 100 200 300\r\n" + 
//			"45 50 600 600 400 450 500 543\r\n" + 
//			"11 120 120 230 50 40 60 440\r\n" + 
//			"35 56 67 90 67 80 500 600";
	
}
